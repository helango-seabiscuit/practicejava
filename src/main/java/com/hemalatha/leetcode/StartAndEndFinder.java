package com.hemalatha.leetcode;

public class StartAndEndFinder {

	public static void main(String[] args) {
		StartAndEndFinder startAndEndFinder = new StartAndEndFinder();
		System.out.print(startAndEndFinder.startOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},4)+",");
		System.out.println(startAndEndFinder.endOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},4)); //6,8
		System.out.print(startAndEndFinder.startOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},3)+",");
		System.out.println(startAndEndFinder.endOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},3));//3,5
	    System.out.print(startAndEndFinder.startOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},5)+",");
		System.out.println(startAndEndFinder.endOfElement(new int[]{0,1,2,3,3,3,4,4,4,5,5},5)); //9,10
		System.out.print(startAndEndFinder.startOfElement(new int[]{0,2,2,2,3,3,3,4,4,4,5,5},2)+",");
		System.out.println(startAndEndFinder.endOfElement(new int[]{0,2,2,2,3,3,3,4,4,4,5,5},2));//1,3
		System.out.print(startAndEndFinder.startOfElement(new int[]{0,2,2,2,3,3,3,4,4,4,5,5},3)+",");
		System.out.println(startAndEndFinder.endOfElement(new int[]{0,2,2,2,3,3,3,4,4,4,5,5},3));//4,6

	}


	public int startOfElement(int[] nums,int elem){
		int lo = 0;
		int high = nums.length-1;

		while (lo < high){
			int mid = lo + (high - lo)/2;

			if(elem > nums[mid]){
				lo = mid+1;
			}else {
				high = mid;
			}
		}
		return high;
	}

	public int endOfElement(int[] nums,int elem){
		int lo = 0;
		int high = nums.length-1;

		while (lo+1 < high){
			int mid = lo + (high - lo)/2;

			if(elem < nums[mid]){
				high = mid-1;
			}else {
				lo = mid;
			}
		}
		return lo;
	}
}
