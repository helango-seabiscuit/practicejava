package com.hemalatha.leetcode;

import java.util.Arrays;

public class BitTest {

	public static void main(String[] args) {

//		for(int num = 20;num>0;num--) {
//			System.out.println();
//			System.out.print(Integer.toBinaryString(num)+" ");
//			int k = num;
//			while (k > 0) {
//				System.out.print(k + " ");
//				k = k & (k - 1);
//			}
//
//		}

		System.out.println(Arrays.toString(countBits(5)));
		System.out.println(Arrays.toString(countBits(10)));
		System.out.println(Arrays.toString(countBits(8)));
	}

	public static int[] countBits(int num) {
		int[] res = new int[num+1];
		res[0]=0;
		res[1] = 1;
		if(num <=1){
			return res;
		}
		for(int i=2;i<=num;i++){
			res[i] = res[i& i-1]+1;
		}
		return res;
	}
}
