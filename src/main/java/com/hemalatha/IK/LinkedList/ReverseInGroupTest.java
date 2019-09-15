package com.hemalatha.IK.LinkedList;

import java.util.Scanner;

/**
 * Created by helangovan on 1/21/17.
 */

public class ReverseInGroupTest {

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
//_insert_node_into_singlylinkedlist
    public static Node insertNode(Node head,Node tail,int val){
        if(head == null){
            head = new Node(val);
            tail = head;
        }else{
            tail.next = new Node(val);
            tail = tail.next;
        }
        return  tail;
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int nums = Integer.parseInt(in.nextLine());
        int listItem = 0;
        Node head = null;
        Node tail = null;
        for(int i =0;i<nums;i++){
            listItem = Integer.parseInt(in.nextLine().trim());
            if(i == 0){
                head = insertNode(head,tail,listItem);
                tail = head;
            }else{
                tail = insertNode(head,tail,listItem);
            }
        }
        int k = Integer.parseInt(in.nextLine().trim());

        Node res = reverseInGroup(head,k);
        while(res!=null){
            System.out.println(res.val+" ");
            res= res.next;
        }
    }

    public static Node reverseInGroup(Node head,int k){
        Node marker = head;
        Node resHead = null;
        Node res = null;
        while(marker !=null){
            Node tHead = marker;
            int c = 1;
            while((c<k) && (marker!=null)){
                marker = marker.next;
                c++;
            }
            if(marker!=null){
                Node prev = marker;
                marker = marker.next;
                prev.next = null;
            }
            Node rev = reverse(tHead);
            if(resHead==null){
                resHead = rev;
                res = rev;
            }else{
                res.next = rev;
            }
            while(res.next!=null){
                res = res.next;
            }

        }
        return resHead;
    }

    public static Node reverse(Node head){

        Node hd;
        if(head==null){
            return null;
        }
        Node next = head.next;
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            curr.next = prev;
            prev= curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }

        return prev;
    }
}
