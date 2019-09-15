package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {


	public static void main(String[] args) {
		TreeNode n = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		n.left = n1;
		n.right = n2;

		n2.left = n3;
		n2.right = n4;
		n3.left = n5;
		System.out.println(height(n));
		System.out.println(serialize(null));
		TreeNode res = deserialize(serialize(null));



	}
	// Encodes a tree to a single string.
	public static  String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int height= height(root);

		List<String> sb = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();

			while (size > 0){
				TreeNode n = queue.poll();
				if(n==null && height>0) {
					sb.add(null);
					queue.add(n);
					queue.add(n);

				}else if(n!=null){
					sb.add(String.valueOf(n.val));

					if (n.left == null && height>0) {
						queue.add(null);
					} else {
						queue.add(n.left);
					}

					if (n.right == null && height >0) {
						queue.add(null);
					} else {
						queue.add(n.right);
					}
				}
				size--;
			}
			height--;


		}

		return String.valueOf(sb);

	}

	private static int height(TreeNode node){
		if(node == null){
			return 0;
		}

		int l = height(node.left);
		int r = height(node.right);
		return l<r? r+1:l+1;
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] arr = data.substring(1,data.length()-1).split(",");
        TreeNode[] res = new TreeNode[arr.length];
        if(arr[0] == null || arr[0].isEmpty()){
        	return null;
		}
        res[0] = new TreeNode(Integer.valueOf(arr[0]));
        for(int i=0;i<arr.length/2;i++){
        	int leftChild = 2*i+1;
        	int rightChild = 2*i+2;

				TreeNode left = arr[leftChild].trim().equalsIgnoreCase("null") ? null : new TreeNode(Integer.valueOf(arr[leftChild].trim()));
				TreeNode right = arr[rightChild].trim().equalsIgnoreCase("null") ? null : new TreeNode(Integer.valueOf(arr[rightChild].trim()));
			if(res[i]!=null) {
				res[i].left = left;
				res[i].right = right;
			}
        	res[leftChild] = left;
        	res[rightChild] = right;
		}

		return res[0];

	}
}
