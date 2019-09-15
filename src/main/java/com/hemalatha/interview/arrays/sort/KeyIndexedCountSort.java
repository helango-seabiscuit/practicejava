package com.hemalatha.interview.arrays.sort;

public class KeyIndexedCountSort {

	/**
	 * @param args
	 */
	private static int R = 256;
	
	public static void main(String[] args) {
		char arr[] = {'b','d','e','c','e','f','c','b','b'};
		countSort(arr);

	}
	
	public static void countSort(char[] arr){
		int []count = new int[R];
		char[] aux = new char[arr.length];
		
		for(int i = 0;i<R;i++)
			count[i] = 0;
		
		for(int i = 0;i<arr.length;i++)
			count[arr[i]] = count[arr[i]]+1;
				
		
		for(int i = 1;i<R;i++)
			count[i] += count[i-1];
				
		
		//place in aux array in sorted order
		for(int i = 0;i<arr.length;i++){
			aux[count[arr[i]]-1] = arr[i];
			//System.out.print(aux[count[arr[i]]-1]+ " ");
			count[arr[i]] = count[arr[i]]-1;
		}
		
		for(int i = 0; i<aux.length;i++)
			System.out.print(aux[i]+ " ");
	}

}
