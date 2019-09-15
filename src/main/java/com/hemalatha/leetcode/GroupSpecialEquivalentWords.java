package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupSpecialEquivalentWords {

	public static void main(String[] args) {
		GroupSpecialEquivalentWords equivalentWords = new GroupSpecialEquivalentWords();
		System.out.println(equivalentWords.numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));//3
		System.out.println(equivalentWords.numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"}));//1
		System.out.println(equivalentWords.numSpecialEquivGroups(new String[]{"aa","bb","ab","ba"}));//4
		System.out.println(equivalentWords.numSpecialEquivGroups(new String[]{"a","b","c","a","c","c"}));//3

		System.out.println(equivalentWords.numSpecialEquivGroupsSol(new String[]{"abc","acb","bac","bca","cab","cba"}));//3
	}

	public int numSpecialEquivGroupsSol(String[] A) {
		Set<String> seen = new HashSet<>();
		for (String S: A) {
			int[] count = new int[52];
			for (int i = 0; i < S.length(); ++i)
				count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
			seen.add(Arrays.toString(count));
		}
		return seen.size();
	}

	public int numSpecialEquivGroups(String[] A) {

		int len = A[0].length();
		Map<String,Integer> counts = new HashMap<>();

		for(String s:A){
			char[] odd = new char[26];
			char[] even = new char[26];
			int i=0;
			while (i<len){
				if(i%2==1){
					odd[s.charAt(i)-'a']++;
				}else{
					even[s.charAt(i)-'a']++;
				}
				i++;
			}
			StringBuilder sb = new StringBuilder();
			for (int k=0;k<26;k++){
				if(even[k]>0) {
					int t = even[k];
                    while (t>0) {
						sb.append('a' + k);
						t--;
					}
				}
			}
			for (int k=0;k<26;k++){
				if(odd[k]>0) {
					int t = odd[k];
					while (t>0) {
						sb.append('a' + k);
						t--;
					}
				}
			}

			counts.put(sb.toString(), counts.getOrDefault(sb.toString(),0)+1);
		}

		return counts.size();
	}
}
