package com.hemalatha.leetcode;

public class PeakIndex {

	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
		System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
		System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
		System.out.println(peakIndexInMountainArray(new int[]{3,4,5,1}));
	}

	public static int peakIndexInMountainArray(int[] A) {
		int l =0;
		int r = A.length-1;

		while (l<r){

			while(l<A.length && A[l]<=A[r]) l++;

			while(r>=0 && l<A.length && A[r]<=A[l]) r--;
		}

		return r;

	}
}
