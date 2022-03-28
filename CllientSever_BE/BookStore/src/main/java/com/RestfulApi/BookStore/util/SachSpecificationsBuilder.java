package com.RestfulApi.BookStore.util;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.data.jpa.domain.Specification;
//
//import com.RestfulApi.BookStore.entity.Sach;

public class SachSpecificationsBuilder {
//	private final List<SearchCriteria> params;
//
//	public SachSpecificationsBuilder() {
//		params = new ArrayList<SearchCriteria>();
//	}
//
//	public SachSpecificationsBuilder with(String key, String operation, Object value) {
//		params.add(new SearchCriteria(key, operation, value));
//		return this;
//	}
//
//	@SuppressWarnings("unchecked")
//	public Specification<Sach> build() {
//		if (params.size() == 0) {
//			return null;
//		}
//
//		@SuppressWarnings("rawtypes")
//		List<Specification> specs = params.stream()
//				.map(spec -> new SachSpecification(spec))
//				.collect(Collectors.toList());// trả về mảng dạng List
//
//		Specification<Sach> result = specs.get(0);
//
//		for (int i = 1; i < params.size(); i++) {
//			result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i))
//					: Specification.where(result).and(specs.get(i));
//		}
//		return result;
//	}
}
