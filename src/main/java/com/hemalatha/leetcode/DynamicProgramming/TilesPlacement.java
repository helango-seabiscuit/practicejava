package com.hemalatha.leetcode.DynamicProgramming;

public class TilesPlacement {


	public static void main(String[] args) {
		TilesPlacement placement = new TilesPlacement();
		System.out.println(placement.countWays(5));
	}

	public int countWays(int n){
		if(n==0){
			return 0;
		}

		if(n==1){
			return 1;
		}

		if(n==2){
			return 2;
		}

		return countWays(n-1)+countWays(n-2);
	}
}
