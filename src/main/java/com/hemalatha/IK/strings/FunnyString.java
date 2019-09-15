package com.hemalatha.IK.strings;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FunnyString {


    public static void main(String[] args) {
        assertEquals("Funny",printFunnyStr("acxz"));
        assertEquals("Not Funny",printFunnyStr("bcxz"));
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        while(n>0){
        String input = in.nextLine().trim();
        System.out.println(printFunnyStr(input));
        n--;
        }


    }

    public static String printFunnyStr(String s){
        if(isFunny(s.toCharArray())){
            return "Funny";
        }
        return "Not Funny";
    }

    public static boolean isFunny(char[] str){
        int len = str.length;
        for(int i=1,j=len-2;i<str.length && j>=0;i++,j--){
            int l1 = Math.abs(str[i]-str[i-1]);
            int l2 = Math.abs(str[j]-str[j+1]);
            if(l1!=l2){
                return false;
            }
        }
        return true;
    }
}
