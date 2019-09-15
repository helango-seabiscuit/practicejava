package com.hemalatha.recursion;

import com.hemalatha.leetcode.TreeNode;

public class TreeToLL {


	private static TreeNode res;
	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(8);
		root.setLeft(left);
		root.setRight(right);
		treeToLinkedList(root);
		System.out.println(res);
	}

	public  static  TreeNode treeToLinkedList(TreeNode root){
		if(root == null){
			return root;
		}

		TreeNode left = treeToLinkedList(root.getLeft());
		TreeNode right = treeToLinkedList(root.getRight());

		if(res == null){
			res = root;
		}

		if(left != null) {
			left.setRight(root);
		}
		root.setLeft(left);

		if(right != null) {
			right.setLeft(root);
		}
		root.setRight(right);
		return root;
	}
}
