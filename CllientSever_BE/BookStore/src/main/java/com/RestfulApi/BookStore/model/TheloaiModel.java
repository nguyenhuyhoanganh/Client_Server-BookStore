package com.RestfulApi.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheloaiModel {
	private int maTheLoai;

	private String icon;

	private String tenTheLoai;
}
