package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/1/17.
 */
public class PalindromCheckTest {


    public static void main(String[] args) {
        System.out.println(inEfficientPalindromeChecker("level"));
        System.out.println(inEfficientPalindromeChecker("madam"));
        System.out.println(inEfficientPalindromeChecker("power"));


        System.out.println(isPalindrome("level",0,4));
        System.out.println(isPalindrome("madam",0,4));
        System.out.println(isPalindrome("power",0,4));
    }

    public static boolean inEfficientPalindromeChecker(String str){
        int len = str.length();
        if(len<=1){
            return true;
        }else{
            return str.charAt(0)==str.charAt(len-1) && inEfficientPalindromeChecker(str.substring(1,len-1));
        }
    }

    public static boolean isPalindrome(String str,int p1,int p2){
        if(p1>=p2){
            return true;
        }else{
            return str.charAt(p1)==str.charAt(p2) && isPalindrome(str,p1+1,p2-1);
        }
    }
}
