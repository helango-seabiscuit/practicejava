package com.hemalatha.recursion;

public class SearchRotatedArray {

	public static void main(String[] args) {
        int arr[] = new int[]{4,5,6,1,2,3};
         arr = new int[]{9,10,11,12,4,5,6,7,8};
         arr = new int[]{10,11,12,5,6,7,8,9};
         arr = new int[]{8,9,20,25,30,34,56,78,1,2,3,5,6,7};
		System.out.println(rotatedArraySearch(arr));
	}

	public static int rotatedArraySearch(int[] arr){
        int res = rotatedArraySearch(arr, 0 , arr.length-1);
        return arr[res];
	}

	public static int rotatedArraySearch(int[] arr, int low,int high){
		//System.out.println("low "+low +" high"+high);
		if(low >= high){
			return low;
		}
		if(arr[low] <=arr[high]){
			return low;
		}

		int mid = (low + high) /2;
		int left = rotatedArraySearch(arr, low,mid);
		int right = rotatedArraySearch(arr, mid+1,high);

		return  arr[left] < arr[right]? left:right;
	}
}
