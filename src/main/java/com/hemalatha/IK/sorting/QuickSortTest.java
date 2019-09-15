package com.hemalatha.IK.sorting;

import java.util.Arrays;

/**
 * Created by helangovan on 2/4/17.
 */
public class QuickSortTest {


    public static void main(String[] args) {
        int arr[] = new int[]{45,25,46,48,28,6,13,5,36,44,7,4,11,30,24,34,15,31,38,49};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public  static void quickSort(int [] arr,int start,int end){
        if(start>end){
            return;
        }
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }


    public static int partition(int []arr,int start,int end){
        int left = start+1;
        int right = end;
        while (left<=right){
            while(arr[left]<arr[start]){
                left++;
            }
            while(arr[right]>arr[start]){   //8,3,1,4,6,12,9
                right--;
            }
            if(left<=right) {
                swap(arr, left, right);//6,7,8,9,16,12
                left++;
                right--;
            }
        }

        swap(arr,right,start);
        return right;
    }

    public static void swap(int[]arr,int s,int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
