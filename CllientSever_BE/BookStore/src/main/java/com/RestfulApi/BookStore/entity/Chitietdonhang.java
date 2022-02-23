package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHITIETDONHANG database table.
 * 
 */
@Entity
@Table(name="CHITIETDONHANG")
@NamedQuery(name="Chitietdonhang.findAll", query="SELECT c FROM Chitietdonhang c")
public class Chitietdonhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChiTietDH;

	private int donGia;

	private int soLuong;

	private String tenSach;

	//bi-directional many-to-one association to Donhang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDonHang")
	private Donhang donhang;

	//bi-directional many-to-one association to Sach
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maSach")
	private Sach sach;

	public Chitietdonhang() {
	}

	public int getMaChiTietDH() {
		return this.maChiTietDH;
	}

	public void setMaChiTietDH(int maChiTietDH) {
		this.maChiTietDH = maChiTietDH;
	}

	public int getDonGia() {
		return this.donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenSach() {
		return this.tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public Donhang getDonhang() {
		return this.donhang;
	}

	public void setDonhang(Donhang donhang) {
		this.donhang = donhang;
	}

	public Sach getSach() {
		return this.sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

}