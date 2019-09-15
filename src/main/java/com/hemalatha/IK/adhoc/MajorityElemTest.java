package com.hemalatha.IK.adhoc;

import java.util.Scanner;

/**
 * Created by helangovan on 2/5/17.
 */
public class MajorityElemTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(getMajorityElement(arr));
    }


    public static int getMajorityElement(int[] arr){
        int count=0;
        int value=0;

        for(int i=0;i<arr.length;i++){
            if(count==0){
                value = arr[i];
                count++;
            }else{
                if(value==arr[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }

        if(count>0 &&isMajority(arr,value)){
              return value;
        }

        return  -1;
    }

    public static  boolean isMajority(int [] arr,int value){
        int check = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                check++;
            }
        }
        return  check > arr.length/2;
    }
}
