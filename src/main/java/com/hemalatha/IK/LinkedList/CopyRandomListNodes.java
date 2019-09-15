package com.hemalatha.IK.LinkedList;


import java.util.Scanner;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }

public class CopyRandomListNodes {

    public static  RandomListNode copyRandomList(RandomListNode head) {
        //sequence copy
        RandomListNode copiedHead = copySequential(head);
        RandomListNode copiedHeadtemp=copiedHead;
        while(copiedHeadtemp!=null){
            System.out.print(copiedHeadtemp.label+" ");
            copiedHeadtemp= copiedHeadtemp.next;
        }
        System.out.println();
        //random copy
        if(copiedHead!=null) {
            RandomListNode randomCopied = copyRandom(copiedHead);
            //remove copy list from original
            RandomListNode dupCopied = removeDupFromOrig(randomCopied);
            return  dupCopied;
        }

        return  copiedHead;

    }

    public static RandomListNode copySequential(RandomListNode head){
        if(head == null){
            return head;
        }
        RandomListNode origPtr = head;
        while (origPtr!=null){
            RandomListNode node = new RandomListNode(origPtr.label);
            node.next = origPtr.next;
            origPtr.next = node;
            origPtr = origPtr.next;
            if(origPtr!=null){
                origPtr = origPtr.next;
            }
        }
        return  head;
    }

    public static  RandomListNode copyRandom(RandomListNode head){
        //assuming head is not null here
        RandomListNode ptr = head;
        RandomListNode cpy = head.next;
        while (ptr!=null){
            cpy.random = ptr.random!=null?ptr.random.next:null;
            ptr = ptr.next!=null?ptr.next.next:ptr.next;
            cpy = cpy.next!=null?cpy.next.next:cpy.next;
        }
        return head;
    }

    public  static  RandomListNode removeDupFromOrig(RandomListNode head){
        RandomListNode origPtr = head;
        RandomListNode dupPtr = head.next;
        RandomListNode dupHead = head.next;

        while (origPtr!=null){
           origPtr.next = origPtr.next==null?null:origPtr.next.next;
           dupPtr.next = dupPtr.next==null?null:dupPtr.next.next;
           origPtr = origPtr.next;
           dupPtr = dupPtr.next;
        }

        return  dupHead;
    }


    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int nums = Integer.parseInt(in.nextLine());
        int listItem = 0;
        RandomListNode head = null;
        RandomListNode tail = null;
        for(int i =0;i<nums;i++){
            listItem = Integer.parseInt(in.nextLine().trim());
            if(i == 0){
                head = insertNode(head,tail,listItem);
                tail = head;
            }else{
                tail = insertNode(head,tail,listItem);
            }
        }
        RandomListNode res = copyRandomList(head);
        while(res!=null){
            System.out.print(res.label+" ");
            res= res.next;
        }
    }

    public static RandomListNode insertNode(RandomListNode head,RandomListNode tail,int val){
        if(head == null){
            head = new RandomListNode(val);
            tail = head;
        }else{
            tail.next = new RandomListNode(val);
            tail = tail.next;
        }
        return  tail;
    }
}




