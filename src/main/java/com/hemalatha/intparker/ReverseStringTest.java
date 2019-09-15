package com.hemalatha.intparker;

public class ReverseStringTest {

	public static void main(String[] args) {
		String s ="Test1ng-Leet=code-Q!";
		System.out.println(reverse(s.toCharArray()));

	}

	private static String reverse(char[] arr){
		int l =0;
		int r = arr.length -1;

		while (l<=r){
			if(Character.isLetter(arr[l]) && Character.isLetter(arr[r])){
				char t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;

				l++;
				r--;
			}else if(!Character.isLetter(arr[l])){
				l++;
			}else{
				r--;
			}
		}
		return new String(arr);
	}
}
