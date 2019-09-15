package com.hemalatha.recursion;


import com.hemalatha.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Ordering
public class BSTArrays {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(8);
		root.setLeft(left);
		root.setRight(right);
		Set<TreeNode> set = new HashSet<>();
		set.add(root);
		List<List<Integer>> list = new ArrayList<>();
		generateBSTArrays(set,new ArrayList<>(), list);

		for(List l:list){
			System.out.println(l);
		}
	}



     public static void generateBSTArrays(Set<TreeNode> set, List<Integer> path, List<List<Integer>> result){
		if(set.isEmpty()){
			result.add(new ArrayList<>(path));
			return;
		}

		for(TreeNode n:new HashSet<>(set)){
			path.add(n.getVal());
			set.remove(n);
			if(n.getLeft() != null){
				set.add(n.getLeft());
			}

			if(n.getRight() != null){
				set.add(n.getRight());
			}
			generateBSTArrays(set,path,result);
			path.remove(path.size()-1);
			if(n.getLeft() != null){
				set.remove(n.getLeft());
			}

			if(n.getRight() != null){
				set.remove(n.getRight());
			}
			set.add(n);
		}
	 }

}
