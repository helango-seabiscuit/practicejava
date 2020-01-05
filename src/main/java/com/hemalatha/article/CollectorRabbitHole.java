package com.hemalatha.article;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorRabbitHole {

	public static void main(String[] args) {


		List<Locale> locale = Arrays.asList(Locale.CANADA, Locale.CHINA, Locale.ITALY, Locale.US, Locale.UK, Locale.JAPAN);
		Map<String, Set<String>> countryToLanguages = locale.stream().collect(
				Collectors.groupingBy(Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet()))
		);



		System.out.println(countryToLanguages);
	}

}
