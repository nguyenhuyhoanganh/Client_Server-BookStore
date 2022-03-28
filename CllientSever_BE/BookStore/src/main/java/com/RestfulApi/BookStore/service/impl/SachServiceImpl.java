package com.RestfulApi.BookStore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestfulApi.BookStore.entity.Nhasanxuat;
import com.RestfulApi.BookStore.entity.Sach;
import com.RestfulApi.BookStore.entity.Theloai;
import com.RestfulApi.BookStore.exception.NotFoundException;
import com.RestfulApi.BookStore.model.SachDTO;
import com.RestfulApi.BookStore.repository.NhaxuatbanRepository;
import com.RestfulApi.BookStore.repository.SachRepository;
import com.RestfulApi.BookStore.repository.TheloaiRepository;
import com.RestfulApi.BookStore.service.ISachService;
import com.RestfulApi.BookStore.util.GenericSpecificationBuilder;

@Service
@Transactional
public class SachServiceImpl implements ISachService {

	@Autowired
	private SachRepository sachRepository;
	@Autowired
	private TheloaiRepository theloaiRepository;
	@Autowired
	private NhaxuatbanRepository nhaxuatbanRepository;

	@Override
	public List<SachDTO> getAll(String search, Integer page, Integer limit, String sortBy) {
		List<SachDTO> listSachModels = new ArrayList<SachDTO>();

		// search
		GenericSpecificationBuilder builder = new GenericSpecificationBuilder();
		Pattern patternSearch = Pattern.compile("(\\w+?)(:|<|>)(\\w+( +\\w+)*$?),", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcherSearch = patternSearch.matcher(search + ",");
		while (matcherSearch.find()) {
			if (matcherSearch.group(1).compareTo("maTheLoai") == 0) {
				builder.with("theloai", matcherSearch.group(2),
						theloaiRepository.findById(Integer.parseInt(matcherSearch.group(3))).get(), "Sach");
			} else if (matcherSearch.group(1).compareTo("maNhaXuatBan") == 0) {
				builder.with("nhasanxuat", matcherSearch.group(2),
						nhaxuatbanRepository.findById(Integer.parseInt(matcherSearch.group(3))).get(), "Sach");
			} else {
				builder.with(matcherSearch.group(1), matcherSearch.group(2), matcherSearch.group(3), "Sach");
			}
		}

		// sort
		List<String> sortList = new ArrayList<String>();
		Pattern patternSortBy = Pattern.compile("(\\w+?),");
		Matcher matcherSortBy = patternSortBy.matcher(sortBy + ",");
		while (matcherSortBy.find()) {
			sortList.add(matcherSortBy.group(1));
		}
		String[] sortArr = new String[sortList.size()];
		sortList.toArray(sortArr);
		Specification<Sach> spec = builder.build();

		// pagination
		List<Sach> listSaches = sachRepository.findAll(spec, PageRequest.of(page, limit, Sort.by(sortArr))).toList();

		// convert to Model
		for (Sach sach : listSaches) {
			SachDTO sachModel = mapToModel(sach);
			listSachModels.add(sachModel);
		}
		return listSachModels;
	}

	@Override
	public SachDTO getById(int id) {
		Optional<Sach> sach = sachRepository.findById(id);
		if (!sach.isPresent())
			throw new NotFoundException("Không tìm thấy sách có id: " + id);
		return mapToModel(sach.get());
	}

	@Override
	public SachDTO create(SachDTO sachModel) {
		Sach sach = sachRepository.save(maptoEntity(sachModel));
		return mapToModel(sach);
	}

	@Override
	public void delete(int id) {
		Optional<Sach> sach = sachRepository.findById(id);
		if (!sach.isPresent())
			throw new NotFoundException("Không tìm thấy sách có id: " + id);
		sachRepository.delete(sach.get());
	}

	@Override
	public SachDTO update(int id, SachDTO sachModel) {
		Sach sach = sachRepository.findById(id).get();
		sach = updatetoEntity(sachModel, sach);
		sachRepository.save(sach);
		return mapToModel(sach);
	}

	@Override
	public long Count() {
		return sachRepository.count();
	}

	public SachDTO mapToModel(Sach sach) {
		SachDTO sachModel = new SachDTO();
		sachModel.setMaSach(sach.getMaSach());
		sachModel.setHinhAnhChinh(sach.getHinhAnhChinh());
		sachModel.setDsHinhAnhPhu(sach.getDsHinhAnhPhu());
		sachModel.setTenSach(sach.getTenSach());
		sachModel.setDonGia(sach.getDonGia());
		sachModel.setMoTa(sach.getMoTa());
		sachModel.setSoLuongMua(sach.getSoLuongMua());
		sachModel.setSoLuongTon(sach.getSoLuongTon());
		sachModel.setNgayCapNhat(sach.getNgayCapNhat());
		sachModel.setNgayTao(sach.getNgayTao());

		sachModel.setTenNhaXuatBan(sach.getNhasanxuat().getTenNhaSanXuat());
		sachModel.setMaTheLoai(sach.getTheloai().getMaTheLoai());
		sachModel.setMaNhaSanXuat(sach.getNhasanxuat().getMaNhaSanXuat());
		sachModel.setTenTheLoai(sach.getTheloai().getTenTheLoai());
		sachModel.setTenDanhMuc(sach.getTheloai().getDanhmuc().getTenDanhMuc());
		return sachModel;
	}

	public Sach maptoEntity(SachDTO sachModel) {
		Sach sach = new Sach();
		sach.setDonGia(sachModel.getDonGia());
		sach.setDsHinhAnhPhu(sachModel.getDsHinhAnhPhu());
		sach.setHinhAnhChinh(sachModel.getHinhAnhChinh());
		sach.setNgayCapNhat(sachModel.getNgayCapNhat());
		sach.setNgayTao(sachModel.getNgayTao());
		sach.setTenSach(sachModel.getTenSach());
		sach.setMoTa(sachModel.getMoTa());
		sach.setSoLuongMua(sachModel.getSoLuongMua());
		sach.setSoLuongTon(sachModel.getSoLuongTon());
		Optional<Theloai> theloai = theloaiRepository.findById(sachModel.getMaTheLoai());
		Optional<Nhasanxuat> nhaxuatban = nhaxuatbanRepository.findById(sachModel.getMaNhaSanXuat());
		if (!theloai.isPresent())
			throw new NotFoundException("Không tìm thấy thể loại sách có id: " + sachModel.getMaTheLoai());
		if (!nhaxuatban.isPresent())
			throw new NotFoundException("Không tìm thấy nhà xuất bản có id: " + sachModel.getMaTheLoai());
		sach.setTheloai(theloai.get());
		sach.setNhasanxuat(nhaxuatban.get());

		return sach;
	}

	public Sach updatetoEntity(SachDTO sachModel, Sach sach) {
		if (sachModel.getDonGia() >= 0)
			sach.setDonGia(sachModel.getDonGia());
		if (sachModel.getDsHinhAnhPhu() != null)
			sach.setDsHinhAnhPhu(sachModel.getDsHinhAnhPhu());
		if (sachModel.getHinhAnhChinh() != null)
			sach.setHinhAnhChinh(sachModel.getHinhAnhChinh());
		if (sachModel.getNgayCapNhat() != null)
			sach.setNgayCapNhat(sachModel.getNgayCapNhat());
		if (sachModel.getNgayTao() != null)
			sach.setNgayTao(sachModel.getNgayTao());
		if (sachModel.getMaTheLoai() != null && theloaiRepository.findById(sachModel.getMaTheLoai()).isPresent())
			sach.setTheloai(theloaiRepository.getById(sachModel.getMaTheLoai()));
		if (sachModel.getMaNhaSanXuat() != null
				&& nhaxuatbanRepository.findById(sachModel.getMaNhaSanXuat()).isPresent())
			sach.setNhasanxuat(nhaxuatbanRepository.getById(sachModel.getMaNhaSanXuat()));
		if (sachModel.getTenSach() != null)
			sach.setTenSach(sachModel.getTenSach());
		if (sachModel.getMoTa() != null)
			sach.setMoTa(sachModel.getMoTa());
		if (sachModel.getSoLuongMua() != null)
			sach.setSoLuongMua(sachModel.getSoLuongMua());
		if (sachModel.getSoLuongTon() != null)
			sach.setSoLuongTon(sachModel.getSoLuongTon());
		return sach;
	}

}
