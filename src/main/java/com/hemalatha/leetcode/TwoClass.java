package com.hemalatha.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class TwoClass {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if (sb.length() > 0  && c < sb.charAt(0)) {
                int index = sb.indexOf(String.valueOf(c));
                if (index != -1){
                    sb.deleteCharAt(index);
                }
                sb.insert(0,c);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = "bcabc";
        char c[] = s.toCharArray();
        for(int i = c.length-1;i>=0;i--){
            int index = sb.indexOf(String.valueOf(c));
            if (index!= -1 && sb.length() > 0) {
                if (c[i] < sb.charAt(0)){
                    sb.deleteCharAt(index);
                    sb.insert(0,c[i]);
                }
            } else {
                sb.insert(0,c[i]);
            }
        }
        System.out.println(sb.toString());
    }

    Map<Integer,Integer> map;
    public TwoClass() {
        map = new TreeMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> s: map.entrySet()){
            if (value >= s.getKey()){
                int rem = value - s.getKey();
                if (map.containsKey(rem)){
                    if (rem == s.getKey() && map.get(rem) == 1){
                        return false;
                    }
                    return true;
                }
            } else {
                break;
            }

        }
        return false;
    }
}
