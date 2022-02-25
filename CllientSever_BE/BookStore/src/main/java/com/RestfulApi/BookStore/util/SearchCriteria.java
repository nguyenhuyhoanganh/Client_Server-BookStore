package com.RestfulApi.BookStore.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
	private String key;
    private String operation;
    private Object value;
    
	public boolean isOrPredicate() {
		// TODO Auto-generated method stub
		return false;
	}
}
