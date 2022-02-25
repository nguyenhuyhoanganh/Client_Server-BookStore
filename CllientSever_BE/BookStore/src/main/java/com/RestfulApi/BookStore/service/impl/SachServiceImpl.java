package com.RestfulApi.BookStore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestfulApi.BookStore.entity.Nhasanxuat;
import com.RestfulApi.BookStore.entity.Sach;
import com.RestfulApi.BookStore.entity.Theloai;
import com.RestfulApi.BookStore.exception.NotFoundException;
import com.RestfulApi.BookStore.model.SachModel;
import com.RestfulApi.BookStore.repository.INhaxuatbanRepository;
import com.RestfulApi.BookStore.repository.ISachRepository;
import com.RestfulApi.BookStore.repository.ITheloaiRepository;
import com.RestfulApi.BookStore.service.ISachService;

@Service
@Transactional
public class SachServiceImpl implements ISachService {

	@Autowired
	private ISachRepository sachRepository;
	@Autowired
	private ITheloaiRepository theloaiRepository;
	@Autowired
	private INhaxuatbanRepository nhaxuatbanRepository;

	@Override
	public List<SachModel> getAll() {
		List<SachModel> listSachModel = new ArrayList<SachModel>();
		for (Sach sach : sachRepository.findAll()) {
			SachModel sachModel = mapToModel(sach);
			listSachModel.add(sachModel);
		}
		return listSachModel;
	}

	@Override
	public SachModel getById(int id) {
		Optional<Sach> sach = sachRepository.findById(id);
		if (!sach.isPresent())
			throw new NotFoundException("Không tìm thấy sách có id: " + id);
		return mapToModel(sach.get());
	}

	@Override
	public SachModel create(SachModel sachModel) {
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
	public SachModel update(int id, SachModel sachModel) {
		Sach sach = sachRepository.findById(id).get();
		sach = updatetoEntity(sachModel, sach);
		sachRepository.save(sach);
		return mapToModel(sach);
	}

	@Override
	public List<SachModel> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long Count() {
		return sachRepository.count();
	}

	public SachModel mapToModel(Sach sach) {
		SachModel sachModel = new SachModel();
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

	public Sach maptoEntity(SachModel sachModel) {
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

	public Sach updatetoEntity(SachModel sachModel, Sach sach) {
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
