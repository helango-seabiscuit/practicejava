package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CandySwap {


	public static void main(String[] args) {
		CandySwap candySwap = new CandySwap();
		System.out.println(Arrays.toString(candySwap.fairCandySwap(new int[]{1,2,5},new int[]{2,4})));//5.4
		System.out.println(Arrays.toString(candySwap.fairCandySwap(new int[]{1,1},new int[]{2,2})));//1,2
		System.out.println(Arrays.toString(candySwap.fairCandySwap(new int[]{1,2},new int[]{2,3})));//1,2
		System.out.println(Arrays.toString(candySwap.fairCandySwap(new int[]{2},new int[]{1,3})));//2,3
		System.out.println(Arrays.toString(candySwap.fairCandySwap(new int[]{1,17,14,1,16},new int[]{26,11})));//2,3
	}
	public int[] fairCandySwap(int[] A, int[] B) {
      int sumA = 0;
      int sumB = 0;

      for(int a:A){
      	sumA+=a;
	  }

		for(int b:B){
			sumB+=b;
		}

		int diff= (sumA-sumB)/2;

		Set<Integer> ASet = new HashSet<>();

		for(int a:A){
			ASet.add(a);
		}

		for(Integer b:B){
			if(ASet.contains(b+diff)){
				return new int[]{b,b+diff};
			}
		}


       return new int[0];
	}
}
