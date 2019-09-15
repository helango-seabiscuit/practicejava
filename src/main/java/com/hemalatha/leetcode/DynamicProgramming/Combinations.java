package com.hemalatha.leetcode.DynamicProgramming;

public class Combinations {


	public int comb(int n,int m){
		if (n==0 || m==0 || n==m){
			return 1;
		}

		return comb(n-1,m)+comb(n-1,m-1);
	}

	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		System.out.println(combinations.comb(5,4));//5
		System.out.println(combinations.comb(6,4));//15
		System.out.println(combinations.comb(6,3));//20
		System.out.println(combinations.comb(6,2));//15
	}
}
