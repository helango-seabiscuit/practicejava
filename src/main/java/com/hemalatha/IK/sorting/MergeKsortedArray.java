package com.hemalatha.IK.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by helangovan on 1/30/17.
 */
class ElementInfo{
    private int value;
    private int arrIndex;
    private int arr;

    ElementInfo(int value,int arr,int arrIndex){
        this.value = value;
        this.arr = arr;
        this.arrIndex = arrIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getArrIndex() {
        return arrIndex;
    }

    public void setArrIndex(int arrIndex) {
        this.arrIndex = arrIndex;
    }

    public int getArr() {
        return arr;
    }

    public void setArr(int arr) {
        this.arr = arr;
    }
}

public class MergeKsortedArray {

    static PriorityQueue<ElementInfo> priorityQueue;
    static Comparator<ElementInfo> comp = (e1,e2)->{return Math.abs(e1.getValue())-Math.abs(e2.getValue());};

    static int[] mergearrays(int[][] iarray) {


        int arrLen = iarray.length;
        int elemLen = iarray[0].length;
        priorityQueue = new PriorityQueue<>(arrLen,comp);
        int i=0;
        int []resArr = new int[arrLen*elemLen];
        while(i<arrLen){
            ElementInfo e = new ElementInfo(iarray[i][0],i,0);
            priorityQueue.offer(e);
            i++;
        }

        i=0;
        while(!priorityQueue.isEmpty()){
                ElementInfo e = priorityQueue.poll();
                resArr[i++] = e.getValue();
                if(e.getArrIndex()+1<iarray[e.getArr()].length){
                     e = new ElementInfo(iarray[e.getArr()][e.getArrIndex()+1],e.getArr(),e.getArrIndex()+1);
                    priorityQueue.offer(e);
                }
        }

       return  resArr;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrRows =0;
        int arrCols = 0;
        arrRows = Integer.parseInt(in.nextLine().trim());
        arrCols = Integer.parseInt(in.nextLine().trim());

        int [][] iarray = new int[arrRows][arrCols];

        for(int i=0;i<arrRows;i++){
            for(int j=0;j<arrCols;j++){
                iarray[i][j] = in.nextInt();
            }
        }

        System.out.println(Arrays.toString(mergearrays(iarray)));

    }
}
