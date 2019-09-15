package com.hemalatha.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


//Ordering
public class Permutations {

	public static void main(String[] args) {
		int [] nums = new int[]{2,3,1};
		List<List<Integer>> res = permute(nums);
		for(List l:res){
			System.out.println(l);
		}

		System.out.println("Permutation with len "+2);
		res = permuteWithLength(nums, 2);
		for(List l:res){
			System.out.println(l);
		}
	}

	public static  List<List<Integer>> permuteWithLength(int[] nums, int len) {
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int a:nums){
			set.add(a);
		}
		permuteOfLength(set, len, new LinkedList<Integer>(),res);
		return res;
	}


	public static  List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
//		if(nums == null || nums.length == 0) {
//			return res;
//		}
//		permute(nums,0,res);
		Set<Integer> set = new HashSet<>();
		for(int a:nums){
			set.add(a);
		}
		permute(set,new LinkedList<Integer>(),res);
		return res;
	}

	public static void permuteOfLength( Set<Integer> set, int length, List<Integer> path, List<List<Integer>> res){
		if(length == 0){
			res.add(new LinkedList<>(path));
			return;
		}

		for(Integer a: new HashSet<>(set)){
			set.remove(a);
			path.add(a);
			permuteOfLength(set, length-1, path,res);
			set.add(a);
			path.remove(path.size()-1);
		}
	}

	public static void permute( Set<Integer> set, List<Integer> path, List<List<Integer>> res){
		if(set.isEmpty()){
			res.add(new LinkedList<>(path));
			return;
		}

		for(Integer a: new HashSet<>(set)){
			set.remove(a);
			path.add(a);
			permute(set, path,res);
			set.add(a);
			path.remove(path.size()-1);
		}
	}

	public static void permute(int[] nums, int i, List<List<Integer>> res){
		if(i == nums.length){
			List<Integer> l = new ArrayList<>();
			for(int n:nums){
				l.add(n);
			}
			res.add(l);
			return;
		}

		for(int j=i;j<nums.length;j++){
			swap(nums,i,j);
			permute(nums,i+1,res);
			swap(nums,i,j);
		}
	}

	private static  void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
