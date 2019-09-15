package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RelativeRanks {

	public static void main(String[] args) {
		RelativeRanks ranks = new RelativeRanks();
		System.out.println(Arrays.toString(ranks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(ranks.findRelativeRanks(new int[]{10,3,8,9,4})));
		System.out.println(Arrays.toString(ranks.findRelativeRanks(new int[]{1})));
	}

	public String[] findRelativeRanks(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			map.put(nums[i],i);
		}


		Arrays.sort(nums);
		int len = nums.length;
		String res[] = new String[len];
		if(len-1>=0) {
			res[map.get(nums[nums.length - 1])] = "Gold Medal";
		}
		if(len-2>=0) {
			res[map.get(nums[nums.length - 2])] = "Silver Medal";
		}
		if(len-3>=0) {
			res[map.get(nums[nums.length - 3])] = "Bronze Medal";
		}
		for (int i=nums.length-4,j=4;i>=0;i--,j++){
			res[map.get(nums[i])]=String.valueOf(j);
		}
		return res;

	}
}
