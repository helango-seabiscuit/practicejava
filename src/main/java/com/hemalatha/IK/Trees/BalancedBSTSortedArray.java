package com.hemalatha.IK.Trees;

/**
 * Created by helangovan on 2/12/17.
 */
public class BalancedBSTSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4,8,9,10,11,12};
        Node root = createBST(arr,0,arr.length-1);
        TreeTraversal traversal = new TreeTraversal();
        traversal.dfs(root);
        System.out.println();
        traversal.bfs(root);
    }

    public static Node createBST(int[] arr,int start,int end){
       if(start>end){
           return null;
       }
       int mid = (start+end)/2;
        Node n = new Node(arr[mid]);
        n.left = createBST(arr,start,mid-1);
        n.right = createBST(arr,mid+1,end);
        return n;
    }
}
