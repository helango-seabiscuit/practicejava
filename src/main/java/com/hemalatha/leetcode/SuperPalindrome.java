package com.hemalatha.leetcode;

public class SuperPalindrome {

//    public int superpalindromesInRange(String L, String R) {
//
//    }

    public static void main(String[] args) {
        SuperPalindrome palindrome = new SuperPalindrome();
        System.out.println(palindrome.isPerfectSquareAndPalin(11));
        System.out.println(palindrome.isPerfectSquareAndPalin(49));
        System.out.println(palindrome.isPerfectSquareAndPalin(121));
        System.out.println(palindrome.isPerfectSquareAndPalin(255));
        System.out.println(palindrome.isPerfectSquareAndPalin(444));
        System.out.println(palindrome.isPerfectSquareAndPalin(676));
        System.out.println(palindrome.isPerfectSquareAndPalin(484));

        System.out.println("Palindrome test");
        System.out.println(palindrome.isPalindrome(49));
        System.out.println(palindrome.isPalindrome(121));
        System.out.println(palindrome.isPalindrome(484));
        System.out.println(palindrome.isPalindrome(220022));
        System.out.println(palindrome.isPalindrome(2222));
        System.out.println(palindrome.isPalindrome(14532));
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
    }

    private  boolean isPerfectSquareAndPalin(long num){
        long r = (long)Math.sqrt(num);
        return r * r == num && isPalindrome(r);
    }

    private boolean isPalindrome(long num){
        String t = String.valueOf(num);
        for(int i=0, j = t.length()-1; i<= j; i++,j--){
            if(t.charAt(i) != t.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
