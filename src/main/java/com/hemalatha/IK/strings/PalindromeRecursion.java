package com.hemalatha.IK.strings;


public class PalindromeRecursion {

    public static void main(String[] args) {
        String s = "madame";
        System.out.println(isPalindrome(s.toCharArray(),0,s.length()-1));
    }

    public static  boolean isPalindrome(char[] arr,int s,int e){
        return  s<e? arr[s]==arr[e] && isPalindrome(arr,s+1,e-1):true;
    }

}
