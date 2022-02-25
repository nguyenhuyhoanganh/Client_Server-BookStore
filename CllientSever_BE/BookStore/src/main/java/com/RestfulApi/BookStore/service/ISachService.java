package com.RestfulApi.BookStore.service;

import java.util.List;

import com.RestfulApi.BookStore.model.SachModel;

public interface ISachService {

	public List<SachModel> getAll(String search, Integer page, Integer limit, String sortBy);

	public SachModel getById(int id);

	public SachModel create(SachModel sachModel);

	public void delete(int id);

	public SachModel update(int id, SachModel sachModel);
	
	public long Count();
}
