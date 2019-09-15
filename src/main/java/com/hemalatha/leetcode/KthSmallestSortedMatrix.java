package com.hemalatha.leetcode;

public class KthSmallestSortedMatrix {

	public static void main(String[] args) {
		KthSmallestSortedMatrix matrix = new KthSmallestSortedMatrix();
//		System.out.println(matrix.kthSmallest(new int[][]{
//				{1,  5,  9},
//				{10, 11, 13},
//				{12, 13, 15}
//		},8));
		System.out.println(matrix.kthSmallest(new int[][]{
				{-5}
		},1));
	}

	public int kthSmallest(int[][] matrix, int k) {
       int n = matrix.length;


       int row = k/n;
       if(row != 0){
       	row = row -1;
	   }
       int col = k%n;
       if(col == 0){
       	col = n-1;
	   }else{
       	col = col-1;
	   }

	   return matrix[row][col];
	}
}
