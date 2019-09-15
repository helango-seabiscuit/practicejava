package com.hemalatha.IK.Trees;

/**
 * Created by helangovan on 2/12/17.
 */
public class KSmallestElements {

    private  static  int count;
    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();
        Node root=traversal.bstInsert(null,10);
        traversal.bstInsert(root,4);
        traversal.bstInsert(root,12);
        traversal.bstInsert(root,6);
        traversal.bstInsert(root,16);
        traversal.bstInsert(root,2);
        traversal.bstInsert(root,5);
        traversal.dfs(root);
        System.out.println();
       // printKSmallest(root,4);
        System.out.println();
        printKSmallest2(root,4);
    }


    public static void printKSmallest(Node root,int k){
        if(root==null){
            return;
        }

        printKSmallest(root.left,k);
        count++;
        if(count<=k){
            System.out.print(root.val+" ");
        }
        printKSmallest(root.right,k);

        return;
    }

    public static void printKSmallest2(Node root,int k){
        if(root==null|| count>=k){
            return;
        }

        printKSmallest2(root.left,k);
        count++;
            System.out.print(root.val+" ");
        printKSmallest2(root.right,k);

        return;
    }
}
