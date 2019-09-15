package com.hemalatha.srm;

import java.util.Arrays;

public class EllysPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] knowledge = new int[]{5, 1, 8, 8, 13, 7, 6, 2, 1, 9, 5, 11, 3, 4};
		System.out.println(findMinEllysPair(knowledge));

	}
	
	public static Integer findMinEllysPair(int[] knowledge){
		int pairedScore[] = new int[knowledge.length/2];
		int length = knowledge.length;
		Arrays.sort(knowledge);
		for(int i=0; i < length/2; i++){
			pairedScore[i] = knowledge[i]+knowledge[length-1-i];
		}
		Arrays.sort(pairedScore);
		return pairedScore[length/2-1]-pairedScore[0];
		
	}

}
