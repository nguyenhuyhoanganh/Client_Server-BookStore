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
 * The persistent class for the DANHMUC database table.
 * 
 */
@Entity
@Table(name="DANHMUC")
@NamedQuery(name="Danhmuc.findAll", query="SELECT d FROM Danhmuc d")
public class Danhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDanhMuc;

	private String tenDanhMuc;

	//bi-directional many-to-one association to Theloai
	@OneToMany(mappedBy="danhmuc")
	private List<Theloai> theloais;

	public Danhmuc() {
	}

	public int getMaDanhMuc() {
		return this.maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return this.tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public List<Theloai> getTheloais() {
		return this.theloais;
	}

	public void setTheloais(List<Theloai> theloais) {
		this.theloais = theloais;
	}

	public Theloai addTheloai(Theloai theloai) {
		getTheloais().add(theloai);
		theloai.setDanhmuc(this);

		return theloai;
	}

	public Theloai removeTheloai(Theloai theloai) {
		getTheloais().remove(theloai);
		theloai.setDanhmuc(null);

		return theloai;
	}

}