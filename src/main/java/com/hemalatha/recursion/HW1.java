package com.hemalatha.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HW1 {


	public static void main(String[] args) {
		System.out.println(f1(3));
		System.out.println(f1(5));
		System.out.println(f2(3));
		System.out.println(f2(4));
		System.out.println(f3(new int[]{1,2,3}));
		System.out.println(f3(new int[]{1,2,3,4}));
		System.out.println(f4(2,6));
		System.out.println(Arrays.toString(minMax(new int[]{4, 6, 2, 8, 1, 11, 3},0)));
		System.out.println(flatten(new int[][]{{1,2,3},{4},{5,6}}));

		System.out.println(subStrings("abcd" ));
	}

	public static int f1(int N){
		if(N<0)return 0;
		if(N==0) return 1;
		return f1(N-1)+f1(N-2)+f1(N-3);
	}


	public static int f2(int N){
		if(N<=1) return 1;
        int total =0;
		for(int i=0;i<N;i++){
		  total += f2(i)*f2(N-i-1);
		}
		return total;
	}

	public static List<List<Integer>> f3(int[] n){
		return f3(n,0);
	}

	public static List<List<Integer>> f3(int[]n,int i){
		if(i==n.length){
			List<List<Integer>> toReturn = new LinkedList<>();
			toReturn.add(new LinkedList<>());
			return toReturn;
		}

		List<List<Integer>> toReturn = new LinkedList<>();
		for (List<Integer> result: f3(n,i+1)){
			toReturn.add(new LinkedList<>(result));
			result.add(0,n[i]);
			toReturn.add(new LinkedList<>(result));
		}
		return toReturn;
	}

	public static int f4(int n,int m){
		if(m==0) return 0;
		if(m==1) return 1;
		if(n==1) return m;

		int max = Integer.MAX_VALUE;
		for(int i=1;i<=m;i++){
			int case1 = f4(n-1,i-1);
			int case2 = f4(n,m-i);
			max = Math.min(max,Math.max(case1,case2));
		}
		return max+1;
	}



	private static int[] minMax(int[] arr,int i){
		if(i>=arr.length){
			return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
		}

		int r[] = minMax(arr,i+1);
		r[0] = Math.min(arr[i],r[0]);
		r[1] = Math.max(arr[i],r[1]);
		return r;
	}

	private static List<Integer> flatten(int arr[][]){
		List<Integer> res = new ArrayList<>();
		//flatten(arr,0,res);
		flattenSol(arr,0,0,res);
		return res;
	}

	private static void flattenSol(int arr[][],int i,int j, List<Integer> res){
		if(i>=arr.length) return;

		if(j>=arr[i].length) {
			flattenSol(arr,i+1,0,res);
			return;
		}
		res.add(arr[i][j]);
		flattenSol(arr,i,j+1,res);
	}

	private static void flatten(int [][] arr, int i, List<Integer> res){
		if(i>=arr.length) return;
		flattenRow(arr,i,0,res);
		flatten(arr,i+1,res);
	}

	private static void flattenRow(int[][] arr, int i, int j, List<Integer> res){
		if(j>=arr[i].length) return;
		res.add(arr[i][j]);
		flattenRow(arr,i,j+1,res);
	}

	private static List<String> subStrings(String s){
		List<String> res = new ArrayList<>();
		subStrings(s,0,1,res);
		return res;
	}

//	private static  void subStrings(String s, int i, int j, List<String> res){
//		if(i>s.length() || j>s.length() || j<i){
//			return;
//		}
//		res.add(s.substring(i,j));
//		subStrings(s,i,j+1,res);
//		subStrings(s,i+1,j+1,res);
//	}

	private static  void subStrings(String s, int i, int j, List<String> res){
		if(i>s.length() || j>s.length()){
			return;
		}

		if(i+1==j)
		subStrings(s,i+1,i+2,res);

		res.add(s.substring(i,j));
		subStrings(s,i,j+1,res);

	}
}
