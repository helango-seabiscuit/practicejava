package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/1/17.
 */
public class BinToDec {

    static int binToDec(String s, int last) {
        if (last < 0) {
            return 0;
        }
        if (s.charAt(last) == '0') {
            return 2 * binToDec(s, last-1);
        }
        return 1 + 2 * binToDec(s, last-1);
    }

    public static void main(String[] args) {
        System.out.println(binToDec("01101",4));
        System.out.println(binToDec("01111",4));
        System.out.println(binToDec("100000",4));
    }
}
