package com.hemalatha.interview.arrays;

public class ArrangeNumbersInOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]={1,2,3,1,2,3,1,2,3};
		int n=arr.length;
		int j=arr.length;
		//arrange(arr,n/2,j/2);
		arrange3(arr,n/3,j/3);
		for(int i:arr)
			System.out.print(i+" ");

	}
	
	public static void arrange(int arr[],int n,int j){
		if(n<0){
			return;
		}
		
		int a=arr[n];
		int b=arr[n+j];
		
		arrange(arr,n-1,j);
		int x=2*n;
		arr[x]=a;
		arr[x+1]=b;
		return;
	}
	
	public static void arrange3(int arr[],int n,int i){
		if(i==1){
			arr[1]=arr[n];
			arr[2]=arr[n<<1];
			return;
		}
		int j=i-1;
		int c=arr[(n<<1)+j];
		int b=arr[n+j];
		int a=arr[j];
		
		arrange3(arr,n,j);
		
		int x=3*j;
		arr[x]=a;
		arr[x+1]=b;
		arr[x+2]=c;
		return;
	}

}
