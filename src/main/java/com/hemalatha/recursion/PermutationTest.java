package com.hemalatha.recursion;

public class PermutationTest {

	public static void main(String[] args) {

		//System.out.println(permutationSet(new char[]{'a','b','c','d'},0));
		System.out.println(permutationSet(new char[]{'1','2','3'},0));
		System.out.println(Math.abs(-2147483648));
		System.out.println(Math.abs(-2));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
		System.out.println(Integer.MIN_VALUE);

		System.out.println(0b1 << 1);
	}


	public static int  permutationSet(char[] arr,int i){
		if(i==arr.length){
			System.out.print("{");
			System.out.print(arr);
			System.out.print("}");
			System.out.println();
			return 1;
		}
		int count =0;
		for (int j=i+1;j<arr.length;j++){
			if(arr[j] >= arr[i]) {
				swap(arr, i, j);
				count += permutationSet(arr, i + 1);
				swap(arr, i, j);
			}

		}
		return count;
	}

	public static void swap(char[]arr,int i,int j){
		char temp = arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}
}
