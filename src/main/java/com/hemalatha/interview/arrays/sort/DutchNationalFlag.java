package com.hemalatha.interview.arrays.sort;

import java.util.Scanner;

/**
 * Created by helangovan on 1/29/17.
 */
public class DutchNationalFlag {

    static String DutchFlagSort(String strColoredBalls) {
        if(strColoredBalls==null || strColoredBalls.isEmpty()){
            return strColoredBalls;
        }
        char balls[]=strColoredBalls.toCharArray();
        int low = 0;
        int mid = 0;
        int high = balls.length-1;
        while(mid<=high){
            if(balls[mid]=='R'){
                swap(balls,low,mid);
                low++;
                mid++;
            }else if(balls[mid]=='G'){
                mid++;
            }else if(balls[mid]=='B'){
                swap(balls,mid,high);
                high--;
            }
        }
        return new String(balls);
    }
    static void swap(char arr[],int l,int r){
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String coloredBalls = null;
        try{
           coloredBalls = in.nextLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(DutchFlagSort(coloredBalls));
    }
}
