package com.hemalatha.srm;

import java.util.Arrays;

public class Mp3Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mp3s[] = new String[]{"1.mp3","2.mp3","10.mp3","4.mp3","11.mp3"};
		Arrays.sort(mp3s);
		System.out.println(Arrays.asList(mp3s));

	}

}
