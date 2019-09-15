package com.hemalatha.IK.DP;

import java.util.Arrays;

/**
 * Created by helangovan on 4/1/17.
 */
//Topcoder tutorial
//Given a sequence of N numbers – A[1] , A[2] , …, A[N] . Find the length of the longest non-decreasing sequence.
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
       int [] nums = new int[]{5,3,4,8,6,7};
       int[] lengths = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            lengths[i]=1;
            for (int j=i;j>0;j--){
                if(lengths[i]<lengths[j-1]+1 && nums[j]>=nums[j-1]){
                   lengths[i] = lengths[j-1]+1;
                }
            }
        }
        System.out.println(Arrays.toString(lengths));
    }
}
