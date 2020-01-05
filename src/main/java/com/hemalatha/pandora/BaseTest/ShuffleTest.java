package com.hemalatha.pandora.BaseTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleTest {

	private static  final List<String> recommendationTypes = Arrays.asList("STATION_MODE_SOURCE", "ENTITY_SOURCE");
	public static void main(String[] args) {

		Collections.shuffle(recommendationTypes);
		System.out.println(recommendationTypes);

		System.out.println(ThreadLocalRandom.current().nextInt(0, 1));
		Optional<String> res = Optional.ofNullable("hello");
		System.out.println(res.get());
		System.out.println(res.get());

	}
}
