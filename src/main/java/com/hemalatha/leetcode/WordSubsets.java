package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

	public static void main(String[] args) {
		WordSubsets s = new WordSubsets();
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"ec","oc","ceo"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","o"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"l","e"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","oo"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"lo","eo"}));
	}

	public List<String> wordSubsets(String[] A, String[] B) {

		int [] submax = new int[26];
		List<String> res = new ArrayList<>();
		for(String s:B){
			int [] subB = new int[26];
          for(Character c:s.toCharArray()){
          	subB[c-'a']+=1;
		  }
		  for(int i=0;i<26;i++){
          	submax[i]= Math.max(subB[i],submax[i]);
		  }
		}

		for(String a:A){
			int[] subA = new int[26];
			for(Character c:a.toCharArray()){
				subA[c-'a']+=1;
			}
			boolean notInclude = false;
			for(int i=0;i<26;i++){
				if(submax[i]>0 && subA[i]<submax[i]){
					notInclude = true;
				}
			}
			if(!notInclude){
				res.add(a);
			}
		}
		return res;
	}
}
