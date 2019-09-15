package com.hemalatha.srm;

import com.hemalatha.interview.arrays.RomanToDecimalConverter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class KingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String []kings = new String[]{"Philippe II","Louis IX", "Louis VIII","Richard III", "Richard I", "Richard II",
				"Philippe VI", "Jean II", "Charles V", "Charles VI","Philippe II", "Charles VII", "Louis XI"};
		System.out.println(doKingSort(kings));

	}
	
	public static List<String>  doKingSort(String[] input){
		Arrays.sort(input,new Comparator<String>() {				
			@Override
			public int compare(String o1, String o2) {
				String first[] = o1.split(" ");
				String second[] = o2.split(" ");
				if(first[0].compareTo(second[0])!=0){
					return first[0].compareTo(second[0]);
				}
				int fir= RomanToDecimalConverter.convertRomanToDecimal(first[1]);
				
				int sec = RomanToDecimalConverter.convertRomanToDecimal(second[1]);
				//System.out.printf("first %d  second %d ",fir,sec);
				return fir-sec;
			}
		});
		return Arrays.asList(input);
	}

}
