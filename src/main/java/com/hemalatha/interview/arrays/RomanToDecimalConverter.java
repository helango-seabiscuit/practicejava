package com.hemalatha.interview.arrays;


public class RomanToDecimalConverter {
	
	/*
	 * {21,"XXI"},
	    		{22,"XXII"},
	    		{23,"XXIII"},
	    		{24,"XXIV"},
	    		{25,"XXV"},
	    		{26,"XXVI"},
	    		{198,"CXCVIII"},
	 */

	private static final String ROMAN_NUMERALS[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	private static final int  DECIMAL_EQUIVALS[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	
	public static Integer convertRomanToDecimal(String roman){
		Integer dec = 0;
		int length = ROMAN_NUMERALS.length;
		for(int i = length - 1; i>=0; i--){
			if(roman.startsWith(ROMAN_NUMERALS[i])){
				do{
				dec +=DECIMAL_EQUIVALS[i];
				roman = roman.substring(ROMAN_NUMERALS[i].length());
				}while(roman.startsWith(ROMAN_NUMERALS[i]));
			}
		}				
		return dec;
	}
}
