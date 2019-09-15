package com.hemalatha.IK.recursion;


import java.util.Arrays;

public class StringNbitsTest {

    static int bin [];
    public static void binary(int n){
        if(n<1){
            System.out.println(Arrays.toString(bin));
        }else{
            bin[n-1]=0;
            binary(n-1);
            bin[n-1]=1;
            binary(n-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        bin = new int[n];
        binary(n);
    }
}
