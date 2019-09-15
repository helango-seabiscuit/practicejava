package com.hemalatha.dyprg;

public class CombinationSetTest {

	public int combo(int arr[],int n){
		if(n == arr.length) return 1;
		int include = combo(arr,n+1);
		int exclude = combo(arr,n+1);
		return include + exclude;
	}
}
