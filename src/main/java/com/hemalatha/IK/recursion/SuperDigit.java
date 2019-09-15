package com.hemalatha.IK.recursion;


import java.util.Scanner;

/**
 * Created by helangovan on 3/14/17.
 */
public class SuperDigit {

    public static void main(String[] args) {
        System.out.println(superDigit(128,3));//6
//        System.out.println(superDigitOuter(148,3));//3

        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int k = in.nextInt();
        System.out.println(superDigit(num,k));//3//      4757362 10000

    }
    public static long superDigit(long number,int k){
       long sum= sum(number);
        return  superDigitOuter(sum,sum,k-1);
    }

    public static long superDigitOuter(long number,long sum,int k){
        if(k<=0){
            return sum;
        }
        sum = sum(sum+number);
        return superDigitOuter(number,sum,k-1);
    }



    public static long sum(long digit){
        long sum = 0;
        do{
            sum=0;
            while (digit > 0) {
                long n = digit % 10;
                digit = digit / 10;
                sum += n;
            }
            digit = sum;
        }while (digit>9);
        return sum;
    }
}
