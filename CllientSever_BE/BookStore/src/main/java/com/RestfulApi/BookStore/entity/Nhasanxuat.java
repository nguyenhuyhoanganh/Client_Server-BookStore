package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the NHASANXUAT database table.
 * 
 */
@Entity
@Table(name="NHASANXUAT")
@NamedQuery(name="Nhasanxuat.findAll", query="SELECT n FROM Nhasanxuat n")
public class Nhasanxuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNhaSanXuat;

	private String logo;

	private String tenNhaSanXuat;

	private String thongTin;

	//bi-directional many-to-one association to Sach
	@OneToMany(mappedBy="nhasanxuat")
	private List<Sach> saches;

	public Nhasanxuat() {
	}

	public int getMaNhaSanXuat() {
		return this.maNhaSanXuat;
	}

	public void setMaNhaSanXuat(int maNhaSanXuat) {
		this.maNhaSanXuat = maNhaSanXuat;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTenNhaSanXuat() {
		return this.tenNhaSanXuat;
	}

	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	public String getThongTin() {
		return this.thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public List<Sach> getSaches() {
		return this.saches;
	}

	public void setSaches(List<Sach> saches) {
		this.saches = saches;
	}

	public Sach addSach(Sach sach) {
		getSaches().add(sach);
		sach.setNhasanxuat(this);

		return sach;
	}

	public Sach removeSach(Sach sach) {
		getSaches().remove(sach);
		sach.setNhasanxuat(null);

		return sach;
	}

}