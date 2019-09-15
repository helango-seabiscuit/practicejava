package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/18/17.
 */
public class Exponential {

    public static void main(String[] args) {
        System.out.println(exponential(2,5));
        System.out.println(exponential(3,3));
    }

    public static Long exponential(Integer base,int power){
      if(power==0){
          return Long.valueOf(1);
      }
      return  base * exponential(base,power-1);
    }
}
