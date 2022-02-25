package com.RestfulApi.BookStore.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private Date timestamp;
	private HttpStatus status;
	private int statusCode;
	private String message;
	private String path;
}