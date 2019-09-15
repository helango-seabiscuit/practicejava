package com.hemalatha.interview.arrays.sort;

public class ShellSort {

	/**
	 * @param args
	 */
	private static int[] arr = {23,45,2,1,56,44,20,9,10,0,4,-10};
	
	public static void main(String[] args) {
		shellSort(arr);
		for(int a :arr)
			System.out.print(a+" ");

	}
	
	public static void shellSort(int []arr){
		int h = 0;
		int length = arr.length;
		while (h < length) h = 3*h + 1;
		
		System.out.println(h);
		while(h > 0){
			for(int i = h; i < length; i ++ ){	
				for(int j=i;j>=h && j<length;j-=h)
				  if( arr[j-h] >= arr[j])
					exchange (j-h,j);
			}
			h = (h - 1) / 3;
			System.out.println(h);
		}
	}
	
	public static void exchange(int first, int second){
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

}
