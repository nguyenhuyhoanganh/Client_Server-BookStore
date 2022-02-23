package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SACH database table.
 * 
 */
@Entity
@Table(name="SACH")
@NamedQuery(name="Sach.findAll", query="SELECT s FROM Sach s")
public class Sach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSach;

	private int donGia;

	private String dsHinhAnhPhu;

	private String hinhAnhChinh;

	private String moTa;

	private Timestamp ngayCapNhat;

	private Timestamp ngayTao;

	private int soLuongMua;

	private int soLuongTon;

	private String tenSach;

	@OneToMany(mappedBy="sach")
	private List<Chitietdonhang> chitietdonhangs;

	@OneToMany(mappedBy="sach")
	private List<Phanhoi> phanhois;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maNhaSanXuat")
	@JsonIgnore
	private Nhasanxuat nhasanxuat;

	@ManyToOne
	(fetch=FetchType.LAZY)
	@JoinColumn(name="maTheLoai")
	@JsonIgnore 
	private Theloai theloai;

	public Sach() {
	}

	public int getMaSach() {
		return this.maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public int getDonGia() {
		return this.donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getDsHinhAnhPhu() {
		return this.dsHinhAnhPhu;
	}

	public void setDsHinhAnhPhu(String dsHinhAnhPhu) {
		this.dsHinhAnhPhu = dsHinhAnhPhu;
	}

	public String getHinhAnhChinh() {
		return this.hinhAnhChinh;
	}

	public void setHinhAnhChinh(String hinhAnhChinh) {
		this.hinhAnhChinh = hinhAnhChinh;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Timestamp getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	public void setNgayCapNhat(Timestamp ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getSoLuongMua() {
		return this.soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public int getSoLuongTon() {
		return this.soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getTenSach() {
		return this.tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public List<Chitietdonhang> getChitietdonhangs() {
		return this.chitietdonhangs;
	}

	public void setChitietdonhangs(List<Chitietdonhang> chitietdonhangs) {
		this.chitietdonhangs = chitietdonhangs;
	}

	public Chitietdonhang addChitietdonhang(Chitietdonhang chitietdonhang) {
		getChitietdonhangs().add(chitietdonhang);
		chitietdonhang.setSach(this);

		return chitietdonhang;
	}

	public Chitietdonhang removeChitietdonhang(Chitietdonhang chitietdonhang) {
		getChitietdonhangs().remove(chitietdonhang);
		chitietdonhang.setSach(null);

		return chitietdonhang;
	}

	public List<Phanhoi> getPhanhois() {
		return this.phanhois;
	}

	public void setPhanhois(List<Phanhoi> phanhois) {
		this.phanhois = phanhois;
	}

	public Phanhoi addPhanhoi(Phanhoi phanhoi) {
		getPhanhois().add(phanhoi);
		phanhoi.setSach(this);

		return phanhoi;
	}

	public Phanhoi removePhanhoi(Phanhoi phanhoi) {
		getPhanhois().remove(phanhoi);
		phanhoi.setSach(null);

		return phanhoi;
	}

	public Nhasanxuat getNhasanxuat() {
		return this.nhasanxuat;
	}

	public void setNhasanxuat(Nhasanxuat nhasanxuat) {
		this.nhasanxuat = nhasanxuat;
	}

	public Theloai getTheloai() {
		return this.theloai;
	}

	public void setTheloai(Theloai theloai) {
		this.theloai = theloai;
	}

}