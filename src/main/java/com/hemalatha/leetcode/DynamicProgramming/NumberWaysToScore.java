package com.hemalatha.leetcode.DynamicProgramming;

public class NumberWaysToScore {

	public static void main(String[] args) {
		NumberWaysToScore score = new NumberWaysToScore();
		System.out.println(score.waysToScore(13));
	}

	public int waysToScore(int n){
		if(n<0){
			return 0;
		}
		if(n==0){
			return 1;
		}

		return waysToScore(n-10)+waysToScore(n-5)+waysToScore(n-3);
	}
}
