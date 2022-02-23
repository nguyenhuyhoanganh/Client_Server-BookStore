package com.RestfulApi.BookStore.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestfulApi.BookStore.model.SachModel;
import com.RestfulApi.BookStore.service.ISachService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class SachController {

	@Autowired
	private ISachService sachService;

	@GetMapping(value = "/books")
	public List<SachModel> getAll() {
		List<SachModel> listSach = sachService.getAll();
		return listSach;
	}

	@GetMapping(value = "/books/{id}")
	public SachModel getOne(@PathVariable int id) {
		SachModel sach = sachService.getById(id);
		return sach;
	}

	@PostMapping(value = "/books")
	public ResponseEntity<SachModel> create(@RequestBody @Valid SachModel sach) {
		Timestamp date = new Timestamp(new Date().getTime());
		sach.setNgayTao(date);
		sach.setNgayCapNhat(date);
		SachModel savedSach = sachService.create(sach);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSach.getMaSach()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/books/{id}")
	public void delete(@PathVariable int id) {
		sachService.delete(id);
	}
}
