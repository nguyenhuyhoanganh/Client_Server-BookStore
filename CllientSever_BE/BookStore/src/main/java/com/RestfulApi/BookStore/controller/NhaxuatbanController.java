package com.RestfulApi.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestfulApi.BookStore.model.NhaxuatbanDTO;
import com.RestfulApi.BookStore.service.INhaxuatbanService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class NhaxuatbanController {
	
	@Autowired private INhaxuatbanService nhaxuatbanService;
	
	@GetMapping(value = "/nxbs")
	public List<NhaxuatbanDTO> getAllNXB(@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "sortBy", required = false) String sortBy) {
		if (search != null)
			search = search.replaceAll("\\s\\s+", " ").trim();
		page = page == null ? page = 0 : page;
		limit = limit == null ? limit = (int) nhaxuatbanService.Count() : limit;
		sortBy = sortBy == null ? sortBy = "maNhaSanXuat" : sortBy.replaceAll("\\s\\s+", " ").trim();
		// loại bỏ khoảng trắng trung lặp đầu cuối
		return nhaxuatbanService.getAll(search, page, limit, sortBy);
	}
}
