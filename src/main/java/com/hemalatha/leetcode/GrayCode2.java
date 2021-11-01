package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode2 {

    public static void main(String[] args) {
        System.out.println(1<<3);
        List<Integer> res = grayCode(4);
        for(int k:res){
            System.out.println(Integer.toBinaryString(k));
        }
    }

    public static List<Integer> grayCode(int numBits){
        if(numBits == 0){
            return Arrays.asList(0);
        }

        if(numBits == 1){
            return Arrays.asList(0,1);
        }

        List<Integer> grayCodeBits = grayCode(numBits-1);

        int leadingBitOne = 1 << (numBits-1);

        List<Integer> reflection = new ArrayList<>();
        for(int i = grayCodeBits.size()-1;i>=0;--i){
            reflection.add(leadingBitOne | grayCodeBits.get(i));
        }

        List<Integer> result = new ArrayList<>(grayCodeBits);
        result.addAll(reflection);
        return result;
    }
}
