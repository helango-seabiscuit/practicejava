package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringTest {

	public static void main(String[] args) {
		System.out.println(IntToBinaryString(71));
		String input = "GFG";
		char[] inp = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<inp.length;i++){
			int asc = inp[i];
			sb.append(IntToBinaryString(asc));
			sb.append(" ");
		}
		System.out.println(sb.toString());
		findAnagrams("cbaebabacd","abc").forEach(s-> System.out.println(s));
		findAnagrams("AAABABAA","AABA").forEach(s-> System.out.println(s));
	}

	public static  String IntToBinaryString(int n){
		StringBuilder sb = new StringBuilder();
		while (n> 0){
			int r = n%2;
			n = n/2;
			sb.insert(0,r);
		}
		return sb.toString();
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int[] pat = new int[256];
		int[] txt = new int[256];

		List<Integer> res = new ArrayList<>();
		for(int i=0;i<p.length();i++){
			pat[p.charAt(i)]++;
		}

		int i=0;
		for(int j=0;j<s.length();j++){
			txt[s.charAt(j)]++;

			if(j-i+1 == p.length()){
				if(isSame(txt,pat)){
					res.add(i);
				}
				txt[s.charAt(i)]--;
				i++;
			}
		}


		return res;
	}

	private static boolean isSame(int[] txt, int [] pat){
		for(int i=0;i<256;i++){
			if(txt[i] != pat[i]){
				return false;
			}
		}
		return true;
	}
}
