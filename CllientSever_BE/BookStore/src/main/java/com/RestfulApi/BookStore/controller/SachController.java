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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestfulApi.BookStore.model.SachModel;
import com.RestfulApi.BookStore.service.ISachService;
import com.RestfulApi.BookStore.valid.OnCreate;
import com.RestfulApi.BookStore.valid.OnUpdate;

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
		SachModel sachModel = sachService.getById(id);
		return sachModel;
	}

	@PostMapping(value = "/books")
	public ResponseEntity<SachModel> create(@RequestBody @Validated(OnCreate.class) SachModel sachModel) {
		Timestamp date = new Timestamp(new Date().getTime());
		sachModel.setNgayTao(date);
		sachModel.setNgayCapNhat(date);
		if (sachModel.getSoLuongMua() <= 0)
			sachModel.setSoLuongMua(0);
		SachModel savedSach = sachService.create(sachModel);
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
	public ResponseEntity<SachModel> update(@PathVariable int id,
			@RequestBody @Validated(OnUpdate.class) SachModel sachModel) {
		sachModel.setNgayCapNhat(new Timestamp(new Date().getTime()));
		return ResponseEntity.ok().body(sachService.update(id, sachModel));
	}
}
