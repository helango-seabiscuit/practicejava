package com.hemalatha.IK.LinkedList;

import java.util.Scanner;


public  class IntersectionListAddr {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertNode(Node head, Node tail, int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        System.out.println(LinkedListIntersection());
    }

    static int LinkedListIntersection() {
        Scanner in = new Scanner(System.in);
        int intersectpoint = Integer.parseInt(in.nextLine());
        int list1 = Integer.parseInt(in.nextLine());
        int listItem = 0;
        Node headlist1 = null;
        Node taillist1 = null;
        Node intersect = null;
        for (int i = 0; i < list1; i++) {
            listItem = Integer.parseInt(in.nextLine().trim());
            if (i == 0) {
                headlist1 = insertNode(headlist1, taillist1, listItem);
                taillist1 = headlist1;
            } else {
                taillist1 = insertNode(headlist1, taillist1, listItem);
            }
            if (intersectpoint == i + 1) {
                intersect = taillist1;
            }
        }

        //get list2
        int list2 = Integer.parseInt(in.nextLine());
        Node headlist2 = null;
        Node taillist2 = null;
        for (int i = 0; i < list2; i++) {
            listItem = Integer.parseInt(in.nextLine().trim());
            if (i == 0) {
                headlist2 = insertNode(headlist2, taillist2, listItem);
                taillist2 = headlist2;
            } else {
                taillist2 = insertNode(headlist2, taillist2, listItem);
            }
        }
        taillist2.next = intersect;
        return LinkedListIntersection(headlist1, headlist2);

    }

    static int LinkedListIntersection(Node head1, Node head2) {
        int l1 = lenLinkedList(head1);
        int l2 = lenLinkedList(head2);
        int diff = 0;
        if (l1 > l2) {
            diff = l1 - l2;
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else if (l2 > l1) {
            diff = l2 - l1;
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1.next == head2.next) {
                return head1.next.val;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    static int lenLinkedList(Node node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}

