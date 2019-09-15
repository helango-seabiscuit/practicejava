package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RangeSumBST {


	public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      public TreeNode(int x) { val = x; }
     }

//	public int rangeSumBST(TreeNode root, int L, int R) {
//		return 0;
//	}
//	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node.left = node2;
		node.right = node3;
		RangeSumBST bst = new RangeSumBST();
		System.out.println(bst.inorderTraversal(node));


	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack();
		st.push(root);
		Set<TreeNode> set = new HashSet<>();
		while(!st.isEmpty()){

			TreeNode curr = st.peek();

			if(curr.left != null && !set.contains(curr.left)){
				st.push(curr.left);
				continue;
			}
			set.add(curr);
			res.add(curr.val);
			st.pop();
			if(curr.right!=null){
				st.push(curr.right);
			}

		}
		return res;

	}
}

