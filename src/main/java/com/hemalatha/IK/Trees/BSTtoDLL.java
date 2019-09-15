package com.hemalatha.IK.Trees;


public class BSTtoDLL {

    static Node head;
    static void BSTtoLL(Node root) {
        BSTtoDLL(root,null);
        Node temp = head;
        while(temp!=head.left){
            System.out.print(temp.val+" ");
            temp = temp.right;
        }

    }

    static void BSTtoDLL(Node root,Node prev){
        if(root==null){
            return;
        }

        BSTtoDLL(root.left,prev);
        root.left = prev;
        if(prev!=null){
            prev.right = root;
        }else{
            head = root;
        }

        Node right = root.right;
        head.left = root;
        root.right = head;
        prev = root;
        BSTtoDLL(right,prev);
    }
}
