package com.hemalatha.leetcode;

public class MedianSortedArrays {

	public static void main(String[] args) {
		MedianSortedArrays arrays = new MedianSortedArrays();
		System.out.println(arrays.findMedianSortedArrays(new int[]{1,3,8,9,15},new int[]{7,11,18,19,21,25})); //11
		System.out.println(arrays.findMedianSortedArrays(new int[]{23,26,31,35},new int[]{3,5,7,9,11,16})); //13.5
		System.out.println(arrays.findMedianSortedArrays(new int[]{1,3},new int[]{2})); //2
		System.out.println(arrays.findMedianSortedArrays(new int[]{1,2},new int[]{3,4})); //2.5
		System.out.println(arrays.findMedianSortedArrays(new int[]{1},new int[]{1})); //1
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int x = nums1.length;
		int y = nums2.length;
		if(x>y){
			return findMedianSortedArrays(nums2,nums1);
		}

		int start = 0;
		int end = x;
		while (start<=end){
			int partitionX = (start+end)/2;
			int partitionY = (x+y+1)/2 - partitionX;

			int leftX = partitionX-1 >= 0 ? nums1[partitionX-1]:Integer.MIN_VALUE;
			int leftY = partitionY-1 >= 0 ?nums2[partitionY-1]:Integer.MIN_VALUE;
			int rightX = partitionX < x? nums1[partitionX]:Integer.MAX_VALUE;
			int rightY = partitionY < y? nums2[partitionY]:Integer.MAX_VALUE;

			if(leftX <= rightY && leftY <= rightX){
				if( (x+y) %2 ==0){
					return (Math.max(leftX,leftY)+Math.min(rightX,rightY))/2.0;
				}else{
					return Math.max(leftX,leftY);
				}
			}else if (leftY > rightX ){
				start = partitionX +1;
			}else{
				end = partitionX -1;
			}
		}
		return 0;
	}
}
