package com.hemalatha.IK.sorting;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/20/17.
 */
public class MedianTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        int i= 0;
        int arr[] = new int[size];
        StringTokenizer st = new StringTokenizer(in.nextLine().trim());
        while(st.hasMoreTokens()){
            arr[i++]= Integer.parseInt(st.nextToken().trim());
        }
        int median = size/2;
        System.out.println(median(arr,0,size-1,median));
    }

    public static int median(int[] arr,int start,int end,int median){
        if(start>end){
            return arr[start];
        }
        int pivot = partition(arr,start,end);
        if(pivot<median){
            return median(arr,pivot+1,end,median);
        }else if(pivot>median){
            return median(arr,start,pivot-1,median);
        }else {
            return arr[pivot];
        }
    }

    public static int partition(int[] arr,int start,int end){
        if(start>=end){
            return start;
        }
        int p = arr[start];
        int l = start+1;
        int r = end;
        while(l<=r){
            while(l<end && arr[l]<p){
                l++;
            }

            while(r>start && arr[r]>=p){
                r--;
            }
            if(l<=r){
                swap(arr,l,r);
                l++;
                r--;
            }
        }

        swap(arr,r,start);
        return r;
    }

    public static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r]= temp;
    }
}
