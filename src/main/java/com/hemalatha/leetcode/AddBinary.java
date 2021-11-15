package com.hemalatha.leetcode;

import java.math.BigInteger;

//https://leetcode.com/problems/add-binary/
public class AddBinary {

    public static void main(String[] args) {
        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("11","1"));
    }
    public String addBinary(String a, String b) {
        BigInteger x =new BigInteger(a,2);
        BigInteger y =new BigInteger(b,2);
        BigInteger carry;
        BigInteger zero = new BigInteger("0",2);
        BigInteger answer;
        while(y.compareTo(zero) != 0 ){
             answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            y = carry;
            x = answer;
        }
        return x.toString(2);
    }
}
