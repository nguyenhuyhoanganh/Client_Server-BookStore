package com.RestfulApi.BookStore.service;

import java.util.List;

import com.RestfulApi.BookStore.model.NhaxuatbanDTO;

public interface INhaxuatbanService {

	List<NhaxuatbanDTO> getAll(String search, Integer page, Integer limit, String sortBy);
	
	long Count();
}
