package com.hemalatha.recursion;

import java.util.LinkedList;
import java.util.List;


//Ordering
public class ArrayOfArrays {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2},{3},{4,5}};
		List<List<Integer>> res = arrayOfArrays(arr);
		for(List<Integer> r : res){
			for(Integer a:r){
				System.out.print(a+" ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> arrayOfArrays(int[][] arr){
		List<List<Integer>> res = new LinkedList<>();
		List<List<Integer>> input = new LinkedList<>();
		for(int[] a:arr){
			List<Integer> l = new LinkedList<>();
			for(Integer i:a){
				l.add(i);
			}
			input.add(l);
		}
		arrayOfArrays(input,new LinkedList<>(), res);
		return res;

	}

	public static void arrayOfArrays(List<List<Integer>> input, List<Integer> path, List<List<Integer>> result){
		if(input.isEmpty()){
			result.add(new LinkedList<>(path));
			return;
		}

		List<Integer> curr = input.remove(0);

		for(Integer a: curr){
			path.add(a);
			arrayOfArrays(input,path,result);
			path.remove(path.size()-1);
		}
		input.add(0,curr);
	}
}
