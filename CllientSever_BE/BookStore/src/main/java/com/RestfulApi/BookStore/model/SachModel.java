package com.RestfulApi.BookStore.model;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SachModel {
	private int maSach;

	@PositiveOrZero(message = "Đơn giá cần là số nguyên lớn hơn 0")
	private int donGia;

	private String dsHinhAnhPhu;
    
	@NotEmpty(message = "Không được để trống hình ảnh")
	private String hinhAnhChinh;

	@NotBlank(message = "Mô tả không được chỉ để khoảng trắng")
	@NotEmpty(message = "Không được để trống mô tả")
	private String moTa;

	@Past(message = "Ngày cập nhật cần trong quá khứ")
	private Timestamp ngayCapNhat;

	@Past(message = "Ngày tạo nhật cần trong quá khứ")
	private Timestamp ngayTao;

	private int soLuongMua;

	@Min(value = 0, message = "Số lượng tồn cần lớn hơn 0")
	private int soLuongTon;

	@NotBlank(message = "Tên sách không được chỉ để khoảng trắng")
	@NotEmpty(message = "Không được để trống tên sách")
	private String tenSach;
	
	
	@Positive(message = "Không được để trống nhà sản xuất")
	private int maNhaSanXuat;
	
	@Positive(message = "Không được để trống thể loại")
	private int maTheLoai;
	
	private String tenTheLoai;
	
	private String tenNhaXuatBan;
	
	private String tenDanhMuc;
	
}
