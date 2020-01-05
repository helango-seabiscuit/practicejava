package com.hemalatha.intparker;

public class BinarySearchTest {

	public static void main(String[] args) {

		int arr[] = new int[] {4,8,12,44,48,56,100};
		//System.out.println(binSearch(arr,100));
		//System.out.println("testing print");

	}

	public static int binSearch(int [] arr, int searchElem){

		int low = 0, high = arr.length-1;

		while (low < high){
			int mid = low + ((high - low)/2);

			if(arr[mid] == searchElem){
				return mid;
			}

			if(searchElem < arr[mid]){
				high = mid -1;
			}
			else{
				low = mid;
			}
		}
		return -1;

	}
}
