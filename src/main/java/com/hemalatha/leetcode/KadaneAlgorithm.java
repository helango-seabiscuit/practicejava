package com.hemalatha.leetcode;

public class KadaneAlgorithm {

    public static void main(String[] args) {

    }


    //not for all -ve array
    public int maxSubArray(int[] arr){
        int currentSum = 0;
        int bestSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum = Math.max(0,currentSum+arr[i]);
            bestSum = Math.max(currentSum,bestSum);
        }
        return bestSum;
    }
}
