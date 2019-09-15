package com.hemalatha.IK.sorting;

/**
 * Created by helangovan on 2/5/17.
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
        System.out.println(reverseString("hemalatha"));
        System.out.println(reverseString("elangovan"));
        System.out.println(reverseString("target"));
    }

    public static String reverseString(String s){
        if(s.length()==0){
            return "";
        }
        String last = s.substring(s.length()-1,s.length());
        String reversed = reverseString(s.substring(0,s.length()-1));
        return last+reversed;
    }


}
