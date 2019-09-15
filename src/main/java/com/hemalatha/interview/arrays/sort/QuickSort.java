package com.hemalatha.interview.arrays.sort;

public class QuickSort {
	
	public static void main(String args[]){
		int arr[]={1,5,6,2,8,12,45,0};
		quickSort(arr, 0, arr.length-1);
		for(int a:arr)
			System.out.print(" "+a);
	}
	
	public static void quickSort(int[] arr,int lower,int upper){
		if(lower>=upper)
			return;
		else{
			int mid=partition(arr,lower,upper);
			quickSort(arr,lower,mid-1);
			quickSort(arr,mid+1,upper);
		}
	}
	
	
	public static int partition(int arr[],int lower,int upper){
		int p=lower+1;
		int q=upper;
		int elem=arr[lower];
		while(p<=q){
			while(arr[p]<elem)
				p++;
			
			while(arr[q]>elem)
				q--;
			
			if(p<q){
				int temp=arr[p];
				arr[p]=arr[q];
				arr[q]=temp;
			}
			
		}
		int temp=arr[q];
		arr[q]=arr[lower];
		arr[lower]=temp;
		return q;
	}

}
