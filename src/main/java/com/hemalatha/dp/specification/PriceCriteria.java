package com.hemalatha.dp.specification;

import com.hemalatha.dp.specification.model.Product;

public class PriceCriteria implements  SearchCriteria {

	public PriceCriteria(Operator operator, double target){

	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return false;
	}
}
