package com.hemalatha.leetcode;

import java.util.Collections;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams anagrams = new Anagrams();
		anagrams.anagrams(0,"abc".toCharArray());
		anagrams.anagrams(0,"abcd".toCharArray());

	}

	public void anagrams(int index,char[] s){
		if(index==s.length){
			System.out.println(s);
			return;
		}

		for(int i=index;i<s.length;i++){
			swap(index,i,s);
			anagrams(index+1,s);
			swap(index,i,s);
		}
	}

	private void swap(int index,int i,char[]s){
		char t = s[index];
		s[index]=s[i];
		s[i]=t;
	}
}
