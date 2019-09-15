package com.hemalatha.interview.arrays;

public class DecimalToRomanConverter {

	/**
	 * @param args
	 */
	private static String ROMAN_NUMERALS[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	private static int  DECIMAL_EQUIVALS[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	
	public static void main(String[] args) {
		System.out.printf("RomanNumeral Equivalent of %d is %s",1800,getRomanEquivalent(1800));

	}
	
	public static String getRomanEquivalent(Integer num){
		StringBuilder roman = new StringBuilder();
		if(num <=0 )
			throw new IllegalArgumentException("Incorrect Number to convert to Romans");
		int i = DECIMAL_EQUIVALS.length-1;
		while(num > 0 || i > 0){
		   if(num >= DECIMAL_EQUIVALS[i-1] && num <DECIMAL_EQUIVALS[i] ){
			   do{
			   roman.append(ROMAN_NUMERALS[i-1]);
			   num -= DECIMAL_EQUIVALS[i-1];
			   }while(num >=DECIMAL_EQUIVALS[i-1]);
		   }else if ( num >= DECIMAL_EQUIVALS[i]){
			    do{
		         roman.append(ROMAN_NUMERALS[i]);
		         num -= DECIMAL_EQUIVALS[i];
			    }while(num >= DECIMAL_EQUIVALS[i]);
		   }
		   i--;
		}
		return roman.toString();
	}

}
