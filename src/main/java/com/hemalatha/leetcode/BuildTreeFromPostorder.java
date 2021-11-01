package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BuildTreeFromPostorder {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public static void main(String[] args) {
      BuildTreeFromPostorder treeFromPostorder = new BuildTreeFromPostorder();
      int[] inorder = new int[]{9,3,15,20,7};
      int[] postOrder = new int[]{9,15,7,20,3};
      TreeNode root = treeFromPostorder.buildTree(inorder,postOrder);
      //TC2
      postOrder = new int[]{9,1,2,12,7,5,3,11,4,8};
      inorder = new int[]{9,5,1,7,2,12,8,4,3,11};
      root = treeFromPostorder.buildTree(inorder,postOrder);
      System.out.println("Result" +root);
    }

    private int[] postOrder;
    private int postIdx;
    private Map<Integer,Integer> idxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.postOrder = postorder;
      this.postIdx = postorder.length-1;
      int idx = 0;
      for(int n:inorder){
          idxMap.put(n, idx++);
      }
      return helper(0,inorder.length-1);
    }

    private TreeNode helper(int leftIndex, int rightIndex){
        if(leftIndex > rightIndex || postIdx < 0){
            return null;
        }
        int val = postOrder[postIdx];
        TreeNode root = new TreeNode(val);
        int index = idxMap.get(val);
        postIdx--;
        root.right = helper(index+1, rightIndex);
        root.left = helper(leftIndex, index-1);
        return root;
    }
}
