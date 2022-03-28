package com.RestfulApi.BookStore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestfulApi.BookStore.model.NhaxuatbanDTO;
import com.RestfulApi.BookStore.entity.Nhasanxuat;
import com.RestfulApi.BookStore.exception.NotFoundException;
import com.RestfulApi.BookStore.repository.NhaxuatbanRepository;
import com.RestfulApi.BookStore.service.INhaxuatbanService;
import com.RestfulApi.BookStore.util.GenericSpecificationBuilder;

@Service
@Transactional
public class NhaxuatbanServiceImpl implements INhaxuatbanService{

	@Autowired 
	NhaxuatbanRepository nhaxuatbanRepository;
	
	@Override
	public List<NhaxuatbanDTO> getAll(String search, Integer page, Integer limit, String sortBy) {
		List<NhaxuatbanDTO> listNxbDTOs = new ArrayList<NhaxuatbanDTO>();

		// search
		GenericSpecificationBuilder builder = new GenericSpecificationBuilder();
		Pattern patternSearch = Pattern.compile("(\\w+?)(:|<|>)(\\w+( +\\w+)*$?),", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcherSearch = patternSearch.matcher(search + ",");
		while (matcherSearch.find()) {
//			if (matcherSearch.group(1).compareTo("maTheLoai") == 0) {
//				builder.with("theloai", matcherSearch.group(2),
//						theloaiRepository.findById(Integer.parseInt(matcherSearch.group(3))).get(), "Sach");
//			} else if (matcherSearch.group(1).compareTo("maNhaXuatBan") == 0) {
//				builder.with("nhasanxuat", matcherSearch.group(2),
//						nhaxuatbanRepository.findById(Integer.parseInt(matcherSearch.group(3))).get(), "Sach");
//			} else {
				builder.with(matcherSearch.group(1), matcherSearch.group(2), matcherSearch.group(3), "Nhasanxuat");
//			}
		}

		// sort
		List<String> sortList = new ArrayList<String>();
		Pattern patternSortBy = Pattern.compile("(\\w+?),");
		Matcher matcherSortBy = patternSortBy.matcher(sortBy + ",");
		while (matcherSortBy.find()) {
			sortList.add(matcherSortBy.group(1));
		}
		String[] sortArr = new String[sortList.size()];
		sortList.toArray(sortArr);
		
		Specification<Nhasanxuat> spec = builder.build();

		// pagination
		List<Nhasanxuat> listNxbs = nhaxuatbanRepository.findAll(spec, PageRequest.of(page, limit, Sort.by(sortArr))).toList();

		if (listNxbs.size() <= 0)
			throw new NotFoundException("Không tìm thấy nxb phù hợp");
		// convert to Model
		for (Nhasanxuat nxb : listNxbs) {
			NhaxuatbanDTO NxbDTO = mapToModel(nxb);
			listNxbDTOs.add(NxbDTO);
		}
		return listNxbDTOs;
	}
	
	public NhaxuatbanDTO mapToModel(Nhasanxuat nxb) {
		NhaxuatbanDTO nxbDTO = new NhaxuatbanDTO();
		nxbDTO.setLogo(nxb.getLogo());
		nxbDTO.setTenNhaSanXuat(nxb.getTenNhaSanXuat());
		nxbDTO.setThongTin(nxb.getThongTin());
		nxbDTO.setMaNhaSanXuat(nxb.getMaNhaSanXuat());
		return nxbDTO;
	}

	@Override
	public long Count() {
		return nhaxuatbanRepository.count();
	}

}
