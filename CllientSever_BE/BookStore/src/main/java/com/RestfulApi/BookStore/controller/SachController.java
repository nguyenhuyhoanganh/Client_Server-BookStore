package com.RestfulApi.BookStore.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestfulApi.BookStore.model.SachDTO;
import com.RestfulApi.BookStore.service.ISachService;
import com.RestfulApi.BookStore.valid.OnCreate;
import com.RestfulApi.BookStore.valid.OnUpdate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class SachController {

	@Autowired
	private ISachService sachService;

//	@GetMapping(value = "/books")
//	public List<SachModel> getAll() {
//		List<SachModel> listSach = sachService.getAll();
//		return listSach;
//	}

	@GetMapping(value = "/books/{id}")
	public SachDTO getOne(@PathVariable int id) {
		SachDTO sachModel = sachService.getById(id);
		return sachModel;
	}

	@PostMapping(value = "/books")
	public ResponseEntity<SachDTO> create(@RequestBody @Validated(OnCreate.class) SachDTO sachModel) {
		Timestamp date = new Timestamp(new Date().getTime());
		sachModel.setNgayTao(date);
		sachModel.setNgayCapNhat(date);
		if (sachModel.getSoLuongMua() <= 0)
			sachModel.setSoLuongMua(0);
		SachDTO savedSach = sachService.create(sachModel);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSach.getMaSach()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/books/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		sachService.delete(id);
		return ResponseEntity.accepted().build();
	}

	@PatchMapping(value = "/books/{id}")
	public ResponseEntity<SachDTO> update(@PathVariable int id,
			@RequestBody @Validated(OnUpdate.class) SachDTO sachModel) {
		sachModel.setNgayCapNhat(new Timestamp(new Date().getTime()));
		return ResponseEntity.ok().body(sachService.update(id, sachModel));
	}

	@GetMapping(value = "/books")
	public List<SachDTO> getAll(@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "sortBy", required = false) String sortBy) {
		if (search != null)
			search = search.replaceAll("\\s\\s+", " ").trim();
		page = page == null ? page = 0 : page;
		limit = limit == null ? limit = (int) sachService.Count() : limit;
		sortBy = sortBy == null ? sortBy = "maSach" : sortBy.replaceAll("\\s\\s+", " ").trim();
		// loại bỏ khoảng trắng trung lặp đầu cuối
		return sachService.getAll(search, page, limit, sortBy);
	}
}
