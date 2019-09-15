package com.hemalatha.IK.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SuperStack {

    static int[] stack;
    static int top;
    static Map<Integer,Integer> incrementCache = new HashMap<>();

    List l= new LinkedList();
    static void superStack(String[] operations) {
        if(operations == null){
            return;
        }
        top = -1;
        stack = new int[operations.length];
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
            if(top<0){
                System.out.println("EMPTY");
            }else{
                System.out.println(stack[top]);
            }
        }
    }

    private static void increment(String[] ops) {
        int incrementer = Integer.parseInt(ops[2].trim());
        int numElems = Integer.parseInt(ops[1].trim());
//        for(Integer ind: incrementCache.keySet()){
//            if(numElems<=ind){
//                int newVal = incrementCache.get(ind)+incrementer;
//                incrementCache.put(ind,newVal);
//            }
//        }
//        incrementCache.put(numElems,incrementer);
        increment(stack,top,numElems,incrementer);
        return;
    }


    private static void pop() {
        stack[top--]=0;
        return;
    }


    private static void push(String[] ops) {
        stack[++top]=Integer.parseInt(ops[1].trim());
        return;
    }

    public static void increment(int[] stack,int top,int numElems,int incrementer){
        int [] temp = new int[top+1];
        for(int i=top,j=0;i>=0;i--,j++){
            temp[j]=stack[i];
        }
        for(int i=0,j=top;j>=0;i++,j--){
            stack[i]= temp[j];
            if(numElems>0){
                stack[i]+=incrementer;
                numElems--;
            }
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
