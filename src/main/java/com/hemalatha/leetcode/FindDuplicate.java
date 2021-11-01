package com.hemalatha.leetcode;

public class FindDuplicate {

    public static void main(String[] args){
        System.out.println(duplicate(new int[]{4,6,4,2,1,3,5})); // {1,2,3,4,4,5,6} => {1->1,2->2,3->3,4->5,5->6,6->7}
    }

    public static int duplicate(int[] nums){
        int low = 1;
        int high = nums.length-1;
        int duplicate = -1;
        int count = 0;
        while(low <= high){
            int mid = (low + high)/2;
            count = 0;
            for(int n:nums){
                if (n <= mid){
                    count++;
                }
            }
            if (count > mid){
                duplicate = mid;
                high = mid -1;
            } else {
                low = mid+1;
            }


        }
        return duplicate;
    }


}
