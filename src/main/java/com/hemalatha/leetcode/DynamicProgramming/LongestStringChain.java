package com.hemalatha.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain stringChain = new LongestStringChain();
        System.out.println(stringChain.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(stringChain.longestStrChainDP(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(stringChain.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(stringChain.longestStrChainDP(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(stringChain.longestStrChain(new String[]{"abcd","dbqca"}));
        System.out.println(stringChain.longestStrChainDP(new String[]{"abcd","dbqca"}));
    }

    public int longestStrChain(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(words));
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        Arrays.sort(words, (w1,w2)-> w2.length()-w1.length());
        for(String word:words) {
            res = Math.max(res,longest(map, word,arrayList));
        }
        return res;
    }

    public int longestStrChainDP(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(String word:words) {
            int presentLength = 1;
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String newWord = sb.toString();
                presentLength = Math.max(presentLength,map.getOrDefault(newWord,0)+1);
            }
            map.put(word,presentLength);
            res = Math.max(presentLength,res);
        }
        return res;
    }


    public int longest(Map<String,Integer> memo, String word, List<String> words){
        if(word.isEmpty()){
            return 0;
        }
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        StringBuilder sb = new StringBuilder(word);
        int max = 1;
        for(int i=0;i<word.length();i++){
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if(words.contains(newWord)){
                max = Math.max(max, longest(memo,newWord, words)+1);
            }
            sb.insert(i, word.charAt(i));

        }
        memo.put(word,max);
        return max;
    }
}
