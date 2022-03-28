package com.RestfulApi.BookStore.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecificationBuilder {
	private final List<SearchCriteria> params;

	public GenericSpecificationBuilder() {
		params = new ArrayList<SearchCriteria>();
	}

	public GenericSpecificationBuilder with(String key, String operation, Object value, String perdicateType) {
		params.add(new SearchCriteria(key, operation, value, perdicateType));
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> Specification<T> build() {
		if (params.size() == 0) {
			return null;
		}

		List<Specification> specs = params.stream().map(x -> getSpecification(x)).collect(Collectors.toList());

		Specification result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			System.out.println(params.get(i).isOrPredicate());
			result = params.get(i - 1).isOrPredicate() ? Specification.where(result).or(specs.get(i))
					: Specification.where(result).and(specs.get(i));
		}
		return result;
	}

	public <T> Specification<T> getSpecification(SearchCriteria criteria) {
		Specification<T> specification = new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate = genericCriteria(criteria, root, criteriaBuilder);
				return predicate;
			}
		};
		return specification;
	}

	public Predicate genericCriteria(SearchCriteria criteria, Root<?> root, CriteriaBuilder builder) {

		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (root.get(criteria.getKey()).getJavaType() == String.class) {
				return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
			} else {
				return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			}
		}
		return null;
	}
}
