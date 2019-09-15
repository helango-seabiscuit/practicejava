package com.hemalatha.recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Ordering
public class SeatArrangements {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,3);
		map.put(3,1);
		List<List<Integer>> res = arrangements(3, map);
		for (List<Integer> a:res){
			for (Integer t:a){
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}

	public  static  List<List<Integer>> arrangements(int N, Map<Integer, Integer> pairs){
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> nums = new LinkedList<>();
		for(int i=1;i<=N;i++){
			nums.add(i);
		}
		arrangements(nums,pairs, new LinkedList<>(), result);
		return result;

	}

	public static void arrangements(List<Integer> nums, Map<Integer, Integer> pairs, List<Integer> path,List<List<Integer>> result ){
      if(nums.isEmpty()){
      	result.add(new LinkedList<>(path));
      	return;
	  }

	  for (Integer a: new LinkedList<>(nums)){
      	path.add(a);
      	nums.remove(a);
      	if(pairs.containsKey(a)){
      		Integer p = pairs.get(a);
      		path.add(p);
      		pairs.remove(a);
      		nums.remove(p);
      		arrangements(nums,pairs,path,result);
      		nums.add(p);
      		pairs.put(a,p);
      		path.remove(path.size()-1);
		}else{
			arrangements(nums,pairs,path,result);
		}
		  nums.add(a);
		  path.remove(path.size()-1);
	  }

	}
}
