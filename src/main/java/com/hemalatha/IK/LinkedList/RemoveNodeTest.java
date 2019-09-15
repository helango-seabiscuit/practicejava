package com.hemalatha.IK.LinkedList;

/**
 * Created by helangovan on 1/15/17.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**

 */



        class Solution{
    public static  class LinkedListNode {
        int val;
        LinkedListNode next;
        LinkedListNode(int nodeValue){
            val = nodeValue;
            next = null;
        }
    };
    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode head = list;
        LinkedListNode ptr = list;
        if(head == null){
            return list;
        }
        if(head.val > x) {
            while (ptr!=null && ptr.val > x) {
                ptr = ptr.next;
                head = ptr;
            }
        }
        while(ptr!=null && ptr.next!=null){
            if(ptr.next.val>x){
                ptr.next = ptr.next.next;
            }else{
                ptr= ptr.next;
            }
        }
        return head;
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
        }

public class RemoveNodeTest {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fname = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
        int listSize = Integer.parseInt(in.nextLine());
        int listI;
        int listItem;
        Solution.LinkedListNode tail = null;
        Solution.LinkedListNode head = null;
        for(listI=0;listI<listSize;listI++){
            listItem = Integer.parseInt(in.nextLine().trim());
            if(listI == 0){
              head = Solution.insertNode(head,tail,listItem);
                tail = head;
            }else{
                tail = Solution.insertNode(head,tail,listItem);
            }
        }
        int x = Integer.parseInt(in.nextLine().trim());
        Solution.LinkedListNode  rem = Solution.removeNodes(head,x);

        while(rem!=null){
            System.out.println(rem.val);
            bw.write(String.valueOf(rem.val));
            bw.newLine();
            rem = rem.next;
        }
        bw.close();
    }

}
