package com.hemalatha.IK.LinkedList;

/**
 * Created by helangovan on 1/22/17.
 */


import java.util.Scanner;

public class MedianCircularQueue {
    static class LinkedListNode{
        int val;
        LinkedListNode next;
        LinkedListNode(int val){
            this.val = val;
        }
    }
    public static LinkedListNode insertNode(LinkedListNode head,LinkedListNode tail,int val){
        if(head == null){
            head = new LinkedListNode(val);
            tail = head;
        }else{
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return  tail;
    }
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int nums = Integer.parseInt(in.nextLine());
        int listItem = 0;
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for(int i =0;i<nums;i++){
            listItem = Integer.parseInt(in.nextLine().trim());
            if(i == 0){
                head = insertNode(head,tail,listItem);
                tail = head;
            }else{
                tail = insertNode(head,tail,listItem);
            }
        }
        tail.next = head;
        //find numberof elements in the CL list;
        int len = countOfElements(head);
        System.out.println("Number of elements: "+len);
        //find start of the CL list i.e. smallest element.
        LinkedListNode start = expectedStartOfList(head);
        //then traverse from start to n/2 lists
        int travNum = len / 2;
        if(len%2==0) {
            travNum += 1;
        }
        while(travNum>0){
            start = start.next;
            travNum--;
        }
        System.out.println("Median:" +start.val);
    }

    public static int countOfElements(LinkedListNode head){
        LinkedListNode temp = head;
        int count = 1;
        while(temp.next!=head){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static LinkedListNode expectedStartOfList(LinkedListNode head){
        int startVal  = head.val;
        LinkedListNode temp = head.next;
        LinkedListNode minNode=head;
        int minValue = head.val;
        while(temp!=head){
            if(temp.val<minValue){
                minValue = temp.val;
                minNode = temp;
            }
            temp = temp.next;
        }
        return minNode;
    }
}
