package com.hemalatha.dp.specification;

import com.hemalatha.dp.specification.model.Television;

import java.util.List;
import java.util.stream.Collectors;

public class SpecificationPatternMain {

	public static void main(String... args) {


		SearchCriteria criteria = new SearchCriteriaBuilder()
				.using(PriceCriteriaBuilder.class).withPrice().being(Operator.lessThan).value(3000)
				.and()
				.using(SizeCriteriaBuilder.class).withScreenSize().being(Operator.largerThan).value(12.1f)
				.build();

		List<Television> televisionList = ProductRepository.getTelevisions()
				.stream()
				.filter(t -> t.satisfies(criteria))
				.collect(Collectors.toList());

		for( Television television : televisionList) {
			System.out.println(television);
		}
	}
}
