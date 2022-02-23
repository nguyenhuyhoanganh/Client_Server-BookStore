package com.RestfulApi.BookStore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestfulApi.BookStore.entity.Sach;
import com.RestfulApi.BookStore.model.SachModel;
import com.RestfulApi.BookStore.repository.INhaxuatbanRepository;
import com.RestfulApi.BookStore.repository.ISachRepository;
import com.RestfulApi.BookStore.repository.ITheloaiRepository;
import com.RestfulApi.BookStore.service.ISachService;
import com.RestfulApi.BookStore.util.NotFoundException;

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
	public SachModel update(SachModel sachModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SachModel> search() {
		// TODO Auto-generated method stub
		return null;
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
		sach.setTheloai(theloaiRepository.getById(sachModel.getMaTheLoai()));
		sach.setNhasanxuat(nhaxuatbanRepository.getById(sachModel.getMaNhaSanXuat()));
		sach.setTenSach(sachModel.getTenSach());
		sach.setMoTa(sachModel.getMoTa());
		sach.setSoLuongMua(sachModel.getSoLuongMua());
		sach.setSoLuongTon(sachModel.getSoLuongTon());
		return sach;
	}

}
