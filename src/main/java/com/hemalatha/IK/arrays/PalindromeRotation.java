package com.hemalatha.IK.arrays;

/**
 * Created by helangovan on 2/19/17.
 */
public class PalindromeRotation {


    public static boolean checkPalindromeRotation(char[] str,int start){
        int len = str.length;
        for(int i=start;i<=len;i++){
            if(isPalindrome(str)){
                return true;
            }
            moveToEnd(str,0,len-1);
        }
        return false;
    }
    public static void moveToEnd(char str[],int s,int e){
        char t = str[s];
        for(int i=0;i<e;i++){
            str[i] = str[i+1];
        }
        str[e]=t;
    }


    public static void swap(char str[],int s,int e){
        char t = str[s];
        str[s] = str[e];
        str[e] = t;
    }

    public static boolean isPalindrome(char[] str){
        int len = str.length;
        for(int i=0;i<len/2;i++){
            if(str[i]!=str[len-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "mmada";
        System.out.println(checkPalindromeRotation(s.toCharArray(),0));
    }
}
