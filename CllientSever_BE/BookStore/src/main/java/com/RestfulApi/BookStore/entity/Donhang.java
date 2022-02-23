package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the DONHANG database table.
 * 
 */
@Entity
@Table(name="DONHANG")
@NamedQuery(name="Donhang.findAll", query="SELECT d FROM Donhang d")
public class Donhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDonHang;

	private boolean daThanhToan;

	private Timestamp ngayDat;

	private Timestamp ngayGiaoDuKien;

	private String tinhTrangGiaoHang;

	private int uuDai;

	//bi-directional many-to-one association to Chitietdonhang
	@OneToMany(mappedBy="donhang")
	private List<Chitietdonhang> chitietdonhangs;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maKhachHang")
	private Khachhang khachhang;

	public Donhang() {
	}

	public int getMaDonHang() {
		return this.maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public boolean getDaThanhToan() {
		return this.daThanhToan;
	}

	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public Timestamp getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Timestamp ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Timestamp getNgayGiaoDuKien() {
		return this.ngayGiaoDuKien;
	}

	public void setNgayGiaoDuKien(Timestamp ngayGiaoDuKien) {
		this.ngayGiaoDuKien = ngayGiaoDuKien;
	}

	public String getTinhTrangGiaoHang() {
		return this.tinhTrangGiaoHang;
	}

	public void setTinhTrangGiaoHang(String tinhTrangGiaoHang) {
		this.tinhTrangGiaoHang = tinhTrangGiaoHang;
	}

	public int getUuDai() {
		return this.uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<Chitietdonhang> getChitietdonhangs() {
		return this.chitietdonhangs;
	}

	public void setChitietdonhangs(List<Chitietdonhang> chitietdonhangs) {
		this.chitietdonhangs = chitietdonhangs;
	}

	public Chitietdonhang addChitietdonhang(Chitietdonhang chitietdonhang) {
		getChitietdonhangs().add(chitietdonhang);
		chitietdonhang.setDonhang(this);

		return chitietdonhang;
	}

	public Chitietdonhang removeChitietdonhang(Chitietdonhang chitietdonhang) {
		getChitietdonhangs().remove(chitietdonhang);
		chitietdonhang.setDonhang(null);

		return chitietdonhang;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}