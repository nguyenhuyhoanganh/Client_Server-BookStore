package com.RestfulApi.BookStore.util;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private Date timestamp;
	private int statusCode;
	private String message;
	private String path;
}