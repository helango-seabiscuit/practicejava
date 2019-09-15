package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/2/17.
 */
public class SumDigits {


    public static void main(String[] args) {
        System.out.println(sumDigit(54));
        System.out.println(sumDigit(258));
        System.out.println(sumDigit(123454567));
    }

    public  static  int sumDigit(int n){
        if(n<=0){
            return  0;
        }
        else{
            int sum =sumDigit(n/10)+n%10;
            return sum;
        }
    }
}
