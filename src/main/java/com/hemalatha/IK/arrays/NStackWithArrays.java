package com.hemalatha.IK.arrays;

import java.util.NoSuchElementException;

public class NStackWithArrays {

    public static void main(String[] args) {
        StackArr arr = new StackArr(3,10);
        arr.push(0,10);
        arr.push(1,3);
        arr.push(2,4);
        arr.push(2,6);
        arr.push(2,8);
        arr.push(0,11);
        arr.push(1,5);
        arr.push(1,7);
        System.out.println(arr.pop(0));
        System.out.println(arr.pop(0));
        System.out.println(arr.pop(1));
        System.out.println(arr.pop(2));
        System.out.println(arr.pop(2));
        System.out.println(arr.pop(1));
        arr.push(1,9);
        System.out.println(arr.pop(1));

    }


}

class StackArr {

    int [] topStack;
    int[] dataStack;
    int [] nextAvailable;
    int availableIndex;

    public StackArr(int numberOfStacks,int totStackSize){
        this.topStack = new int[numberOfStacks];
        this.dataStack = new int[totStackSize];
        this.nextAvailable = new int[totStackSize];
        availableIndex = 0;
        for(int i=0;i<topStack.length;i++){
            topStack[i]=-1;
        }
        for(int i=0;i<totStackSize-1;i++){
            nextAvailable[i]= i+1;
        }
        nextAvailable[totStackSize-1]= -1;
    }

    public void push(int stack,int element){
        if(stack<0 || stack >= topStack.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        if(availableIndex ==-1){
            throw new IllegalStateException("Stack is full");
        }

        int currIndex = availableIndex;
        availableIndex = nextAvailable[currIndex];
        nextAvailable[currIndex]= topStack[stack];
        dataStack[currIndex]= element;
        topStack[stack] = currIndex;
    }

    public int pop(int stack){
        if(stack<0 || stack >= topStack.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        if(topStack[stack]==-1){
            throw  new NoSuchElementException("Stack is Empty");
        }

        int currIndex = topStack[stack];
        int val = dataStack[currIndex];
        topStack[stack] = nextAvailable[currIndex];
        nextAvailable[currIndex] = availableIndex;
        availableIndex = currIndex;
        return val;
    }
}
