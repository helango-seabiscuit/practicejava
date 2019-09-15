package com.hemalatha.IK.sorting;

import java.util.Scanner;

/**
 * Created by helangovan on 2/5/17.
 */
public class SumIntegers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrSize = 0;
        arrSize = Integer.parseInt(in.nextLine().trim());
        int [] intArr = new int[arrSize];
        for(int i=0;i<arrSize;i++){
            intArr[i] = Integer.parseInt(in.nextLine().trim());
        }

        int target = Integer.parseInt(in.nextLine().trim());
        System.out.println(groupSum(intArr,target));
    }

    static boolean groupSum(int[] IntArr, int iTarget) {
        return groupSumLimit(IntArr,0,IntArr.length,iTarget);
    }

    static boolean groupSumLimit(int[] arr,int start,int end,int target){
       if(start>=end){
           if(target==0){
               return true;
           }
           return false;
       }else{
              return groupSumLimit(arr,start+1,end,target) || groupSumLimit(arr,start+1,end,target-arr[start]);
       }
    }
}
