package com.hemalatha.gfg;

public class Matrix {

	public static void main(String[] args) {
		int arr[][] = {{1,2,3,4},{5,6,7,8},{9,1,1,1}};
		lower(arr);
		System.out.println();
		upper(arr);
	}

	public static void lower(int [][]arr){

		for (int i=0;i<arr.length;i++){
			for (int j=0;j< arr[0].length;j++){
				if(i < j){
					System.out.print(0+" ");
				}else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void upper(int [][]arr){

		for (int i=0;i<arr.length;i++){
			for (int j=0;j< arr[0].length;j++){
				if(i > j){
					System.out.print(0+" ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}


}
