package com.hemalatha.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Ordering
public class PermutationWithDuplicates {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(1);
		List<List<Integer>> res = permutations(l);

		for(List lt:res){
			System.out.println(lt);
		}
	}

	public static List<List<Integer>> permutations(List<Integer> items){
		List<List<Integer>> result = new LinkedList<>();
		Map<Integer,Integer> itemCounts = new HashMap<>();
		for(int i:items){
			if(itemCounts.containsKey(i)) {
				itemCounts.put(i, itemCounts.get(i) + 1);
			}else{
				itemCounts.put(i,1);
			}
		}

		permutations(itemCounts,new LinkedList<>(),result);
		return result;
	}


	private static void permutations(Map<Integer,Integer> itemCounts, List<Integer> path, List<List<Integer>> result){
		if(itemCounts.isEmpty()){
			result.add(new LinkedList<>(path));
			return;
		}

		for(Integer i:new HashSet<>(itemCounts.keySet())){
			int curr = itemCounts.get(i);
            if(curr == 1){
            	itemCounts.remove(i);
			}else{
            	itemCounts.put(i, curr-1);
			}

			path.add(i);
            permutations(itemCounts,path,result);
            itemCounts.put(i,curr);
            path.remove(path.size()-1);
		}
	}
}
