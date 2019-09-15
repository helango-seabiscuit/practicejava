package com.hemalatha.interview.arrays.sort;

public class THREEWayPartitionDNF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr = {1,1,0,0,2,2,1,0,1,2,0,1};
		threewayPartition(arr);

	}
	
	public static void threewayPartition(int[] arr){
		int i,lt,gt;
		i = 0;
		lt = 0;
		gt = arr.length-1;
		
		while(i<=gt){
			if(arr[i] < arr[lt]){
				exchange(i,lt,arr);
				lt++;i++;
			}
			else if (arr[i] > arr[lt]){
				exchange(i,gt,arr);
				gt--;
			}
			else
				i++;
		}
		for(int a:arr)
			System.out.print(a+" ");
		System.out.printf("\nPosition of lt %d , gt %d , i %d",lt,gt,i);
	}
	
	public static void exchange(int l,int u,int arr[]){
		int temp = arr[l];
		arr[l] = arr[u];
		arr[u] = temp;
	}

}
