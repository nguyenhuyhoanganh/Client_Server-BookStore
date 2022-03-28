package com.RestfulApi.BookStore.service;

import java.util.List;

import com.RestfulApi.BookStore.model.SachDTO;

public interface ISachService {

	public List<SachDTO> getAll(String search, Integer page, Integer limit, String sortBy);

	public SachDTO getById(int id);

	public SachDTO create(SachDTO sachModel);

	public void delete(int id);

	public SachDTO update(int id, SachDTO sachModel);
	
	public long Count();
}
