package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestWord {


	public static void main(String[] args) {
		LongestWord word = new LongestWord();
		System.out.println(word.longestWord(new String[]{"w","wo","wor","worl", "world"}));
		System.out.println(word.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
	}
	public String longestWord(String[] words) {

		PriorityQueue<String> pq = new PriorityQueue<>((w1, w2)->{
			if(w1.length() == w2.length()){
				return w1.compareTo(w2);
			}
			return Integer.valueOf(w2.length()).compareTo(w1.length());
		});
		Set<String> set = new HashSet<>();
		for(String s:words){
			set.add(s);
			pq.add(s);
		}

		while(!pq.isEmpty()){
			String s = pq.poll();
			int len = s.length();
			int i=1;
			while(i<len){
				if(!set.contains(s.substring(0,s.length()-i))){
					break;
				}
				i++;
			}
			if(i==len){
				return s;
			}
		}
		return "";
	}
}
