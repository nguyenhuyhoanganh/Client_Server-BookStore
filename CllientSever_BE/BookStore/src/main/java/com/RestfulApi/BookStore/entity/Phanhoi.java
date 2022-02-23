package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PHANHOI database table.
 * 
 */
@Entity
@Table(name="PHANHOI")
@NamedQuery(name="Phanhoi.findAll", query="SELECT p FROM Phanhoi p")
public class Phanhoi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maPhanHoi;

	private int danhGia;

	private Timestamp ngayTao;

	private String noiDung;

	//bi-directional many-to-one association to Sach
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maSach")
	private Sach sach;

	//bi-directional many-to-one association to Thanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maThanhVien")
	private Thanhvien thanhvien;

	public Phanhoi() {
	}

	public int getMaPhanHoi() {
		return this.maPhanHoi;
	}

	public void setMaPhanHoi(int maPhanHoi) {
		this.maPhanHoi = maPhanHoi;
	}

	public int getDanhGia() {
		return this.danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}

	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Sach getSach() {
		return this.sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public Thanhvien getThanhvien() {
		return this.thanhvien;
	}

	public void setThanhvien(Thanhvien thanhvien) {
		this.thanhvien = thanhvien;
	}

}