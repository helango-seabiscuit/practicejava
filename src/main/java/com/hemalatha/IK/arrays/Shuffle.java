package com.hemalatha.IK.arrays;

import java.util.Arrays;

/**
 * Created by helangovan on 2/9/17.
 */
public class Shuffle {

    public static  void shuffle(int[] arr){
//        int n = arr.length;
//        for(int i=n-1,j=n-1;i>=0;i--,j--){
//            int r = random(0,i);
//            swap(arr,r,j);
//        }
//
//        return arr;
        int[] arr1=new int[]{89,-4,6,0};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args) {
      shuffle(null);
    }
}
