package com.hemalatha.IK.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by helangovan on 4/2/17.
 */

//Given a string find length of longest substring T that contains at most 2 distinct characters
public class LongestSubstringDistinctChars {

    static String longestSub(String strText) {
        int len = strText.length();
        Pair result = null;
        Map<Character,Integer> count =null;
        for(int left = 0; left<len;left++){
            count = new HashMap<>();
            int distinct =0;
            for(int right=left;right<len;right++){
                char mat = strText.charAt(right);
                int c = count.getOrDefault(mat,0);
                if(c==0){
                    distinct++;
                }
                count.put(mat,++c);
                if(distinct==2){
                    if(result==null || right-left> result.right-result.left)
                        result = new Pair(left,right);
                }else if(distinct>2){
                    break;
                }
            }
        }
        return result==null ? "":strText.substring(result.left,result.right+1);

    }

    static class Pair{
        int left;
        int right;
        Pair(int left,int right){
            this.left = left;
            this.right = right;
        }
    }
}
