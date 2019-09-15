package com.hemalatha.IK.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by helangovan on 3/14/17.
 */
public class Calorie {


    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] calories = new int[n];
            for(int calories_i=0; calories_i < n; calories_i++){
                calories[calories_i] = in.nextInt();
            }
            Arrays.sort(calories);
            long sum=0;
            int j=0;
            for(int i=n-1;i>=0;i--){
                sum=sum+(long)(calories[i]*Math.pow(2,j++));
            }
            System.out.println(sum);
         //40
        //819 701 578 403 50 400 983 665 510 523 696 532 51 449 333 234 958 460 277 347 950 53 123 227 646 190 938 61 409 110 61 178 659 989 625 237 944 550 954 439
        //Expected 59715404338867
        //Got 2147483647
    }
}
