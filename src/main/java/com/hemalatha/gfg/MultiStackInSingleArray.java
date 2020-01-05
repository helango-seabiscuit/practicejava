package com.hemalatha.gfg;

import java.util.Arrays;
//https://www.youtube.com/watch?v=S5cYO9k1Ja8
//K stacks in a single array
public class MultiStackInSingleArray {

    private int[] arr;
    private int[] next;
    private  int[] topStack;
    private int free;

    public MultiStackInSingleArray(int numOfStack, int sizeOfArray) {
        arr = new int[sizeOfArray];
        next = new int[sizeOfArray];
        topStack = new int[numOfStack];
        Arrays.fill(topStack, -1);
        for(int i = 0; i< sizeOfArray-1;i++){
            next[i] = i+1;
        }
        next[sizeOfArray-1] = -1;
        free = 0;
    }

    public void push(int elem, int stack){
        if(isFull()){
            return;
        }
        arr[free] = elem;
        int t = topStack[stack];
        topStack[stack] = free;
        int tempFree = free;
        free = next[free];
        next[tempFree]= t;
    }

    public int pop(int stack){
        if(topStack[stack] == -1){
            return -1;
        }
        int index = topStack[stack];
        topStack[stack] = next[index];
        next[index] = free;
        free = index;
        return arr[index];
    }

    public boolean isEmpty(){
        return free != -1;
    }

    public boolean isFull(){
        return free == -1;
    }

    public  String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i:arr){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiStackInSingleArray stackInSingleArray = new MultiStackInSingleArray(4,7);
        stackInSingleArray.push(12,2);
        stackInSingleArray.push(16,2);
        stackInSingleArray.push(18,2);
        stackInSingleArray.push(10,0);
        stackInSingleArray.push(14,1);
        stackInSingleArray.push(19,3);
        stackInSingleArray.push(24,3);
        System.out.println(stackInSingleArray.toString());
        System.out.println(stackInSingleArray.pop(3));
        System.out.println(stackInSingleArray.pop(0));
        System.out.println(stackInSingleArray.pop(2));
    }
}
