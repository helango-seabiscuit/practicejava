package com.hemalatha.leetcode;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class SwapNodesLinkedList {

    public static void main(String[] args) {
       ListNode root = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
       swapNodes(root,2);
       while(root != null){
           System.out.print(root.val+" ");
           root = root.next;
       }
    }

    public static ListNode swapNodes(ListNode head, int k) {
       ListNode current = head;
       ListNode front = null;
       ListNode end = null;
       int i =1;
       while(current != null){
           if(i == k){
               front = current;
               end = head;
           } else if(end != null){
               end = end.next;
           }
           current = current.next;
           i++;
       }

       int temp = front.val;
       front.val = end.val;
       end.val = temp;
       return head;
    }
}
