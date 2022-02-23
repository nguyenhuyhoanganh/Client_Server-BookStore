package com.RestfulApi.BookStore.entity;

import java.io.Serializable;
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


/**
 * The persistent class for the THELOAI database table.
 * 
 */
@Entity
@Table(name="THELOAI")
@NamedQuery(name="Theloai.findAll", query="SELECT t FROM Theloai t")
public class Theloai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maTheLoai;

	private String icon;

	private String tenTheLoai;

	//bi-directional many-to-one association to Sach
	@OneToMany(mappedBy="theloai")
	private List<Sach> saches;

	//bi-directional many-to-one association to Danhmuc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDanhMuc")
	private Danhmuc danhmuc;

	public Theloai() {
	}

	public int getMaTheLoai() {
		return this.maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTenTheLoai() {
		return this.tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<Sach> getSaches() {
		return this.saches;
	}

	public void setSaches(List<Sach> saches) {
		this.saches = saches;
	}

	public Sach addSach(Sach sach) {
		getSaches().add(sach);
		sach.setTheloai(this);

		return sach;
	}

	public Sach removeSach(Sach sach) {
		getSaches().remove(sach);
		sach.setTheloai(null);

		return sach;
	}

	public Danhmuc getDanhmuc() {
		return this.danhmuc;
	}

	public void setDanhmuc(Danhmuc danhmuc) {
		this.danhmuc = danhmuc;
	}

}