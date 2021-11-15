package com.hemalatha.leetcode;

//https://leetcode.com/problems/single-number-ii/
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
       // int x = singleNumber.singleNumber(new int[]{1, 2, 2, 1, 1, 2, 4});
       int x = singleNumber.singleNumber(new int[]{ 2, 2, 2});
        System.out.println(x);

    }

    public int singleNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}
