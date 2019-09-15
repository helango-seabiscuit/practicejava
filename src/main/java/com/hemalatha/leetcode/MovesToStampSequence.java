package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//todo -- incomplete
public class MovesToStampSequence {

	public static void main(String[] args) {
		MovesToStampSequence sequence = new MovesToStampSequence();
		System.out.println(Arrays.toString(sequence.movesToStamp("abc","ababc")));
		System.out.println(Arrays.toString(sequence.movesToStamp("abca","aabcaca")));
	}

	public int[] movesToStamp(String stamp, String target) {

		List<Integer> res = new ArrayList<>();
		int len = target.length();
		int l = stamp.length();
        for(int i=0;i<=len-l;i++){
//     	  if(i+l<len){
     		res.add(i);
		 //}
	    }

	    int[] k = new int[res.size()];
        int i=0;
	    for(int n:res){
        	k[i++]=n;
		}
		return k;

	}
}
