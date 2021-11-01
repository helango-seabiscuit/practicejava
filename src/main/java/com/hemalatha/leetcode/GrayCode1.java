package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode1 {

    public static void main(String[] args) {

        System.out.println(grayCode(3));
        for(int i =0;i< 8;i++){
            System.out.println((1<<i)+" "+(1<<i ^ 1) );
        }
    }

    public static List<Integer> grayCode(int numBits){
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        directedGrayCode(numBits, new HashSet<>(Arrays.asList(0)), result);
        return result;
    }

    private static boolean directedGrayCode(int numBits, Set<Integer> history, List<Integer> result){
        if(result.size() == (1<< numBits)){
            return differByOneBit(result.get(0), result.get(result.size()-1));
        }

        for(int i =0;i<numBits;i++){
            int previousCode = result.get(result.size() -1);
            int candidateNextCode = previousCode ^ (1<<i);
            if(!history.contains(candidateNextCode)){
                history.add(candidateNextCode);
                result.add(candidateNextCode);
                if(directedGrayCode(numBits, history,result)){
                    return true;
                }
                history.remove(candidateNextCode);
                result.remove(result.size()-1);
            }
        }
        return false;
    }

    private static  boolean differByOneBit(int x , int y){
        int bitDifference = x ^ y;
        return bitDifference != 0 && (bitDifference & bitDifference -1) == 0;
    }
}
