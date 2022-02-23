package com.RestfulApi.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaxuatbanModel {
	private int maNhaSanXuat;

	private String logo;

	private String tenNhaSanXuat;

	private String thongTin;
}
