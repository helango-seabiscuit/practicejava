package com.hemalatha.jsontoenum;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class JsonMapApp {

	public static void main(String[] args) {
		final Config conf = ConfigFactory.load();
		final String cheese = conf.getString("swiss.cheese");
		System.out.println(String.format("I like %s ", cheese));

		final Cheese che = getEnumProperty(conf, "swiss.cheese", Cheese.class);
		if (Cheese.GRUYERE.equals(che)){
			System.out.println(String.format("I really like %s ", che));
		}
	}

	private static <E extends Enum<E>> E getEnumProperty(final Config conf, final String key, final Class<E> myClass){
		if (conf == null){
			return null;
		}

		if (!conf.hasPath(key)){
			return null;
		}

		final String keyValue = conf.getString(key);
		if (keyValue == null || keyValue.isEmpty()){
			return null;
		}

		return Enum.valueOf(myClass, keyValue.toUpperCase());
	}
}
