package com.hemalatha.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {


	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		System.out.println(subsetSum.isSubsetRecursion(new int[]{3,2,7,1},0,6,new ArrayList<Integer>()));
	}

	private boolean isSubsetRecursion(int[] arr, int i, int target, List<Integer> res){
		if(target==0){
			System.out.println(res);
			return true;
		}

		if(i==arr.length){
			return false;
		}



		boolean r = isSubsetRecursion(arr,i+1,target,res);
		res.add(arr[i]);
		boolean l = isSubsetRecursion(arr,i+1,target-arr[i],res);
		res.remove(arr[i]);
		return r || l;
	}
}
