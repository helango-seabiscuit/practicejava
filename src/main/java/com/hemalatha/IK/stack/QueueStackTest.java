package com.hemalatha.IK.stack;


import java.util.Scanner;
import java.util.Stack;

public class QueueStackTest {

    private static  Stack<Integer> pushStack;
    private static  Stack<Integer> popStack;

    QueueStackTest(){}

    static {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfOps = Integer.parseInt(in.nextLine());
        int [] ops = new int[noOfOps];
        int i=0;
        while (noOfOps>0){
            ops[i++]= Integer.parseInt(in.nextLine());
            noOfOps--;
        }
        for(Integer op:ops){
            if(op<0){
                dequeue();
            }else{
                enqueue(op);
            }
        }
        System.out.println("Pushstack "+pushStack);
        System.out.println("Popstack "+popStack);
    }

    public static void enqueue(int val){
        pushStack.push(val);
    }

    public  static int dequeue(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty()){
            return -1;
        }
        return  popStack.pop();
    }
}
