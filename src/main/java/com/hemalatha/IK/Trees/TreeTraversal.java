package com.hemalatha.IK.Trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by helangovan on 2/2/17.
 */

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class TreeTraversal {


    public void dfsIteratively(Node root){
        Stack<Node> s = new Stack<>();

        if(root!=null){
            s.push(root);
        }

        while(!s.isEmpty()){
            Node temp = s.pop();
            System.out.println(temp.val);
            if(temp.right!=null){
                s.push(temp.right);
            }
            if(temp.left!=null){
                s.push(temp.left);
            }
        }
    }

    public void dfs(Node root){
        if(root ==null){
            return;
        }

        dfs(root.left);
        System.out.print(root.val+" ");
        dfs(root.right);
    }

    public void bfs(Node root){
        Queue<Node> q = new ConcurrentLinkedQueue();

        if(root!=null){
            q.add(root);
        }

        while(!q.isEmpty()){
            Node t = q.poll();
            System.out.print(t.val+" ");
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
    }

    Node bstInsert(Node root,int val){
        if(root==null){
            return new Node(val);
        }

        if(val<root.val){
            root.left= bstInsert(root.left,val);
        }else if(val > root.val){
            root.right = bstInsert(root.right,val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();
        Node root=traversal.bstInsert(null,10);
        traversal.bstInsert(root,4);
        traversal.bstInsert(root,12);
        traversal.bstInsert(root,6);
        traversal.bstInsert(root,16);
        System.out.println("DFS ");
        traversal.dfs(root);
        System.out.println();
        TreeIterator it = new TreeIterator(root);
        System.out.println("Tree Iterator".toCharArray());
        while(it.hasNext()){
            System.out.print(it.next().val+" ");
        }
    }

     static void postOrderIterative(Node root){
         Stack<Node> tStack = new Stack<>();
         Stack<Node> output = new Stack<>();
         if(root!=null) {
             tStack.push(root);
         }

         while (!tStack.isEmpty()){
             Node t = tStack.pop();
             output.push(t);
             if(t.left!=null){
                 tStack.push(t.left);
             }
             if(t.right!=null){
                 tStack.push(t.right);
             }
         }

         while (!output.isEmpty()){
             System.out.print(output.pop().val+" ");
         }

     }





}
