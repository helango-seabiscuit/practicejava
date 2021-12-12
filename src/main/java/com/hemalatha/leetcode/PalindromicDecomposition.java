package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {

    private static boolean isFound = false;
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        palindromeDecompose("611116",0,new ArrayList<>(), result );
        System.out.println(result);
        result.clear();
        palindromeDecompose("racecarannakayak",0,new ArrayList<>(),result);
        System.out.println(result);

    }

    public static void palindromeDecompose(String input, int offset, List<String> partition, List<List<String>> result){
        if(offset == input.length() ){
//            if(partition.size()>1){
                result.add(new ArrayList<>(partition));
                isFound = true;
//            }
            return;
        }

        for(int i = offset+1; i<=input.length();i++){
            String prefix = input.substring(offset,i);
            if(isPalindrome(prefix)  ){
                partition.add(prefix);
                palindromeDecompose(input, i,partition,result);
                partition.remove(partition.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String check){
        for(int i=0,j=check.length()-1;i<j;i++,j--){
            if(check.charAt(i) != check.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
