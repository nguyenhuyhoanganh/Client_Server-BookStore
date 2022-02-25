package com.RestfulApi.BookStore.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.RestfulApi.BookStore.valid.OnCreate;
import com.RestfulApi.BookStore.valid.OnUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SachModel {
	private Integer maSach;

	@PositiveOrZero(message = "Đơn giá cần là số nguyên lớn hơn 0", groups = { OnUpdate.class, OnCreate.class })
	@NotNull(message = "Đơn giá không được để trống", groups = { OnCreate.class })
	private Integer donGia;

	private String dsHinhAnhPhu;

	@NotBlank(message = "Không được để trống hình ảnh", groups = { OnCreate.class })
	private String hinhAnhChinh;

	@NotBlank(message = "Mô tả không được chỉ để trống", groups = { OnCreate.class })
	private String moTa;

	@Past(message = "Ngày cập nhật cần trong quá khứ", groups = { OnCreate.class })
	private Timestamp ngayCapNhat;

	@Past(message = "Ngày tạo nhật cần trong quá khứ", groups = { OnCreate.class })
	private Timestamp ngayTao;

	private Integer soLuongMua;

	@PositiveOrZero(message = "Số lượng tồn cần lớn hơn 0", groups = { OnUpdate.class, OnCreate.class })
	@NotNull(message = "Số lượng tồn không được để trống", groups = { OnCreate.class })
	private Integer soLuongTon;

	@NotBlank(message = "Tên sách không được để trống", groups = { OnCreate.class })
	private String tenSach;

	@Positive(message = "Không được để trống nhà sản xuất", groups = { OnCreate.class })
	private Integer maNhaSanXuat;

	@Positive(message = "Không được để trống thể loại", groups = { OnCreate.class })
	private Integer maTheLoai;

	private String tenTheLoai;

	private String tenNhaXuatBan;

	private String tenDanhMuc;

}
