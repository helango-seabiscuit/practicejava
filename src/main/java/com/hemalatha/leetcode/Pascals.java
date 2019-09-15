package com.hemalatha.leetcode;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class Pascals {

	public static void main(String[] args) {
		int arr[][] = new int [5][5];
		pascalTriangle(arr,5);
		for(int [] a:arr)
		System.out.println(Arrays.toString(a));

		System.out.println(ZonedDateTime.now().toOffsetDateTime().toString());
		System.out.println(ZonedDateTime.now());
		System.out.println(pascalTriangle1(2,1));
		System.out.println(pascalTriangle1(4,3));
		System.out.println(pascalTriangle1(4,2));
	}

	private static void pascalTriangle(int[][] arr,int n){

		int c =1;
		for(int i=0;i<n;i++){
			 c = i+1;
			for(int j=0;j<n;j++){
					if (j == 0 || i == j) {
						arr[i][j] = 1;
					} else {
						if (i - 1 >= 0) {
							int l = j - 1 >= 0 ? arr[i - 1][j-1] : 0;
							int r = arr[i - 1][j];
							arr[i][j] = l + r;
						}
				}
			}
		}
	}

	public static int pascalTriangle1(int row, int col){
		if(col == 0 || row == col){
			return 1;
		}

		int res = pascalTriangle1(row-1,col)+pascalTriangle1(row-1, col-1);
		return res;

	}

//	public List<Integer> getRow(int rowIndex) {
//
//	}
}
