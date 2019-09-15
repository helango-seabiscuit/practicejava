package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayUniqueTest {

	public static void main(String[] args) {
		ArrayUniqueTest test = new ArrayUniqueTest();
		System.out.println(test.minIncrementForUnique(new int[]{3,2,1,2,1,7,7,8,8}));
	}

//	public int minIncrementForUnique(int[] A) {
//		int[] count = new int[100000];
//		for (int x: A) count[x]++;
//
//		int ans = 0, taken = 0;
//
//		for (int x = 0; x < 100000; ++x) {
//			if (count[x] >= 2) {
//				taken += count[x] - 1;
//				ans -= x * (count[x] - 1);
//			}
//			else if (taken > 0 && count[x] == 0) {
//				taken--;
//				ans += x;
//			}
//		}
//
//		return ans;
//	}

	public int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int res = 0, need = 0;
		for (int a : A) {
			res += Math.max(need - a, 0);
			need = Math.max(a, need) + 1;
		}
		return res;
	}
}
