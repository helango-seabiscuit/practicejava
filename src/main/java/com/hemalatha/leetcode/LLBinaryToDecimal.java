package com.hemalatha.leetcode;

public class LLBinaryToDecimal {

    public static void main(String[] args) {
        System.out.println(binaryToDecimal("1011"));
        System.out.println(binaryToDecimal("101"));
        System.out.println(binaryToDecimal("011"));
        System.out.println(binaryToDecimal("1111"));

        ListNode ll = new ListNode(1,new ListNode(0,new ListNode(1,new ListNode(1))));
        System.out.println(binaryToDecimal(ll));
    }

    public static long binaryToDecimal(ListNode head){
        long res = 0;
        while(head != null){
            res = res *2 + head.val;
            head = head.next;
        }
        return res;
    }

    public static long binaryToDecimal(String s){
        long res = 0;
        for(char c:s.toCharArray()){
            res = (res *2 + c-'0');
        }
        return res;
    }
}
