package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

	public static void main(String[] args) {
		FruitBasket basket = new FruitBasket();
		System.out.println(basket.totalFruit(new int[]{1,2,1}));//3
		System.out.println(basket.totalFruit(new int[]{0,1,2,2}));//3
		System.out.println(basket.totalFruit(new int[]{1,2,3,2,2}));//4
		System.out.println(basket.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));//5
		System.out.println(basket.totalFruit(new int[]{0,1,6,6,4,4,6}));//5
		System.out.println(basket.totalFruit(new int[]{4,1,1,1,3,1,7,5}));//5
		System.out.println(basket.totalFruit(new int[]{1,9,1,8,22,0,22,19,19,2,19,6,6,19,2,20,2,9,9,9,9,16,19,16,19,11,19,0,19,19}));//5
	}

	public int totalFruit(int[] tree) {
		int max = 0, count = 0;
		for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
			count++;
			if (tree[i] == tree[first]) {
				first = i;
			} else if (second == -1 || tree[i] == tree[second]) {
				second = i;
			} else {
				max = Math.max(count - 1, max);
				count = Math.abs(first - second) + 1;
				first = i - 1;
				second = i;
			}
		}
		return Math.max(count, max);

	}
}
