package com.hemalatha.leetcode;

import org.apache.commons.lang3.StringUtils;

public class Test {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(197));
		System.out.println(Integer.toBinaryString(130));
		System.out.println(StringUtils.leftPad(Integer.toBinaryString(1),8,'0'));
		System.out.println(Math.pow(2,7));
		System.out.println(Integer.toBinaryString(128));
		System.out.println(Integer.toBinaryString(127));
		System.out.println(Integer.toBinaryString(250));
		System.out.println(Integer.toBinaryString(145));
		System.out.println(Integer.toBinaryString(145));
		System.out.println(Integer.toBinaryString(145));
		System.out.println(Integer.toBinaryString(145));
		System.out.println(validUtf8(new int[]{250,145,145,145,145}));

	}

	public static  boolean validUtf8(int[] data) {
		if(data==null || data.length==0) return false;
		boolean isValid = true;
		for(int i=0;i<data.length;i++) {
			if(data[i]>255) return false; // 1 after 8th digit, 100000000
			int numberOfBytes = 0;
			if((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
				numberOfBytes = 1;
			} else if((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
				numberOfBytes = 2;
			} else if((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
				numberOfBytes = 3;
			} else if((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
				numberOfBytes = 4;
			} else {
				return false;
			}
			for(int j=1;j<numberOfBytes;j++) { // check that the next n bytes start with 10xxxxxx
				if(i+j>=data.length) return false;
				if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
			}
			i=i+numberOfBytes-1;
		}
		return isValid;
	}







}
