package com.hemalatha.dp.specification;

import com.hemalatha.dp.specification.model.Product;

import java.util.Iterator;
import java.util.List;

public class Criteria implements SearchCriteria {

	private List<SearchCriteria> criteria;

	public Criteria(List<SearchCriteria> criteria) {
		this.criteria = criteria;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		Iterator<SearchCriteria> iterator = criteria.iterator();
		while ((iterator.hasNext())){
			if(!iterator.next().isSatisfiedBy(product)){
				return false;
			}
		}
		return true;
	}
}
