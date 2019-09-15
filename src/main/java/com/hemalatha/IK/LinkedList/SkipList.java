package com.hemalatha.IK.LinkedList;

import java.util.Random;

//skiplist good description http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/skip-list-impl.html
//http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/Progs/SkipList/SkipList.java
class SkipListNode{
    int key;
    SkipListNode next;
    SkipListNode prev;
    SkipListNode above;
    SkipListNode below;

    SkipListNode(int key){
        this.key = key;
    }
}

public class SkipList {
    SkipListNode head;
    SkipListNode tail;
    int h;
    int numOfElems;
    Random random;

    SkipList(){
        head = new SkipListNode(Integer.MIN_VALUE);
        tail = new SkipListNode(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        h=0;
        numOfElems=0;
        random = new Random();
    }

    private SkipListNode findEntry(int key){
        SkipListNode ptr = head;
        while(true){
            while(ptr.next.key!=Integer.MAX_VALUE && ptr.next.key<= key){
                ptr = ptr.next;
            }
            if(ptr.below!=null){
                ptr = ptr.below;
            }else{
                break;
            }
        }
        return ptr;
    }

    private void insertNode(int key){
        SkipListNode p = findEntry(key);

        if(p.key == key){
            return;
        }
        int i =0;
        SkipListNode node = new SkipListNode(key);

        node.next = p.next;
        p.next.prev = node;
        p.next = node;
        node.prev = p;
        while(random.nextDouble()>0.5){
            if(i>=h){
                h=h+1;
                SkipListNode newHead = new SkipListNode(Integer.MIN_VALUE);
                SkipListNode newTail = new SkipListNode(Integer.MAX_VALUE);
                newHead.next = tail;
                newTail.prev = head;

                newHead.below = head;
                newTail.below = tail;

                head.above = newHead;
                tail.above = newTail;
                head = newHead;
                tail = newTail;
            }

            while(p.above ==null){
                p = p.prev;
            }
            p= p.above;
            SkipListNode e = new SkipListNode(key);
            e.prev = p;
            e.next = p.next;
            p.next.prev = e;
            p.next = e;

            e.below = node;
            node.above = e;
            node = e;
            i++;
        }
        numOfElems++;
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insertNode(4);
        skipList.insertNode(8);
        skipList.insertNode(12);
        skipList.insertNode(10);
        System.out.println(skipList.findEntry(10).key + " Found");
        System.out.println(skipList.findEntry(4).key + " Found");


    }

}
