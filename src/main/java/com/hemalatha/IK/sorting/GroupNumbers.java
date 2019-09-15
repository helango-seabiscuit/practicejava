package com.hemalatha.IK.sorting;

/**
 * Created by helangovan on 2/14/17.
 */
public class GroupNumbers {

    static int[] groupNumbers(int[] intArr) {
        if(intArr ==null || intArr.length<=1){
            return intArr;
        }

        int len = intArr.length;
        int left = 0;
        int right =intArr.length-1;;

        while(right>=left){
            while(intArr[left]%2==0 && left<len){
                left++;
            }
            while(intArr[right]%2==1 && right>=0){
                right--;
            }
            if(left<=right){
                int temp = intArr[left];
                intArr[left] = intArr[right];
                intArr[right]=temp;
                left++;
                right--;
            }
        }
        return intArr;
    }

}
