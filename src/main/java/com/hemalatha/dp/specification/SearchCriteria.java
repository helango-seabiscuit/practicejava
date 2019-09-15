package com.hemalatha.dp.specification;

import com.hemalatha.dp.specification.model.Product;

public interface SearchCriteria {

	boolean isSatisfiedBy(Product product);
}
