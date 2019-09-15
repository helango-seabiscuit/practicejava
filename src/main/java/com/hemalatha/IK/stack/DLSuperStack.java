package com.hemalatha.IK.stack;

import java.util.Scanner;


class Node{
    int val;
    Node prev;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class DLSuperStack {


    static  Node head;
    static int count;
    static void superStack(String[] operations) {
        if(operations == null){
            return;
        }

        for(String op:operations){
            String [] ops=op.split("\\s+");

            switch(ops[0].trim().toLowerCase()){
                case "push":
                    push(ops);
                    break;
                case "pop":
                    pop();
                    break;
                case "inc":
                    increment(ops);
                    break;
            }
            if(head==null){
                System.out.println("EMPTY");
            }else{
                System.out.println(head.val);
            }
        }
    }

    private static void increment(String[] ops) {
        int incrementer = Integer.parseInt(ops[2].trim());
        int numElems = Integer.parseInt(ops[1].trim());
        increment(numElems,incrementer);
        return;
    }

    private static  void pop(){
        if(head == null){
            return;
        }
        Node ptr = head;
        if(ptr.next == ptr){
            ptr.next = null;
            ptr.prev = null;
            head = null;
            count--;
            return;
        }

        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
        head = ptr.next;
        count--;
    }


    private static  void push(String[] ops){
        int val = Integer.parseInt(ops[1].trim());
        Node node = new Node(val);
        if(head == null){
            node.next = node;
            node.prev = node;
            head = node;
            count++;
            return;
        }

        node.next = head;
        node.prev = head.prev;
        head.prev.next=node;
        head.prev = node;
        head = node;
        count++;
    }



    public static void increment(int numElems,int incrementer){
        Node ptr = head.prev;
        int counter = count;
        while (numElems > 0 && counter>0 ){
            ptr.val +=incrementer;
            ptr = ptr.prev;
            numElems--;
            counter--;
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int operationsSize =0 ;
        operationsSize = Integer.parseInt(in.nextLine().trim());
        String [] operations = new String[operationsSize];
        for(int i=0;i<operationsSize;i++){
            operations[i] = in.nextLine();
        }

        superStack(operations);
    }
}

