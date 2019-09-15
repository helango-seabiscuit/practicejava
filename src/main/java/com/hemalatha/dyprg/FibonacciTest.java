package com.hemalatha.dyprg;

public class FibonacciTest {

	public int fibo(int n){
		if(n==0) return 0;
		if(n == 1) return 1;
		return fibo(n-1)+fibo(n-2);
	}

	public int fiboDP(int n){
		int[] arr = new int[n+1];
		arr[1]=1;
		return fiboTopDown(arr,n);
	}

	public int fiboTopDown(int[] arr,int n){
		if(n ==0 || n==1){
			return arr[n];
		}else if(arr[n]==0){
			arr[n] = fibo(n-1)+fibo(n-2);
		}
		return arr[n];
	}

	public int fiboBottomUp(int n){
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n;i++){
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr[n];
	}




}

