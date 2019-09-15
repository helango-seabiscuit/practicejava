package com.hemalatha.interview.bits;

public class ReverseBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 8;
		int temp = 0;
		System.out.println(temp >> 1);
	
		while (num != 0){
			temp <<= 1;
			temp |= (num & 1 );
		    num >>= 1;
			
			
		}
		System.out.println(temp );

	}

}
