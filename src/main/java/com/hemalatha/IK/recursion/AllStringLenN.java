package com.hemalatha.IK.recursion;

import java.util.Arrays;

/**
 * Created by helangovan on 2/1/17.
 */

//Didnt understand this quite well
    //Todo plz understand recursion
public class AllStringLenN {

    static int[]arr;
    public static void kString(int n,int k){
        if(n<1){
            System.out.println(Arrays.toString(arr));
        }else{
            for(int j=0;j<k;j++){
                arr[n-1]=j;
                kString(n-1,k);
            }
        }
    }

    public static void main(String[] args) {
        int n=5;
        int k=3;
        arr = new int[n];
       // kString(n,k);
        printStringForLoop("abcd".toCharArray(),0);
    }

    public  static void printStringForLoop(char[] str,int start){
        int len = str.length;
        if(start>=len){
            System.out.println(str);
            return;
        }

        for(int i=start;i<len;i++){
             swap(str,start,i);
            printStringForLoop(str,start+1);
            swap(str,start,i);
        }
    }

    public static void swap(char[] str,int s,int e){
        char t = str[s];
        str[s]=str[e];
        str[e]=t;
    }
}
