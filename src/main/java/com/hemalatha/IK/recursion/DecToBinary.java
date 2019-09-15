package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/1/17.
 */
public class DecToBinary {

    public static void decToBin(int n){
        if(n>0){
            decToBin(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        decToBin(4);
        System.out.println();
        decToBin(15);
        System.out.println();
        decToBin(32);
    }
}
