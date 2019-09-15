package com.hemalatha.leetcode.DynamicProgramming;

public class NumberOfPaths {

	public static void main(String[] args) {
		NumberOfPaths paths = new NumberOfPaths();
		System.out.println(paths.countPaths(4));//20
		System.out.println(paths.countPaths(3));//6
	}

	public int countPaths(int n){
		return countPaths(0,0,n);
	}

	public int countPaths(int i,int j,int n){
		if(i>=n || j>= n){
			return 0;
		}

		if(i==n-1 && j==n-1){
			return 1;
		}

		return countPaths(i,j+1,n)+countPaths(i+1,j,n);
	}
}
