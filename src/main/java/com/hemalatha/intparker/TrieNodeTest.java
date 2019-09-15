package com.hemalatha.intparker;

import io.netty.util.internal.MathUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrieNodeTest {

	public static void main(String[] args) {




//		String words[] = {"time", "me","top","hello","ello"};
//		Set<String> wrds = new HashSet<>(Arrays.asList(words));
//
//		for(String w:words){
//			for(int i=1;i<w.length();i++){
//				wrds.remove(w.substring(i));
//			}
//		}
//
//		for (String w:wrds){
//			System.out.println(w);
//		}


		//using trie node that puts characters of string in reverse order
		// if the tail character's count is 0 then that is unique character
//	  Map<TrieNode,Integer> nodes = new HashMap<>();
//      String words[] = {"hello", "top"};
//		TrieNode temp = new TrieNode();
//		for (int i = 0; i < words.length;i++){
//			String w = words[i];
//			TrieNode curr = temp;
//			for(int j=w.length()-1;j>=0;j--){
//				curr = curr.getChar(w.charAt(j));
//			}
//			nodes.put(curr,i);
//		}
//
//		int ans = 0;
//		for(TrieNode node:nodes.keySet()){
//			if(node.count == 0){
//				ans += words[nodes.get(node)].length();
//			}
//		}
//		System.out.println(ans);
		String s ="";
		System.out.println(String.format("%s",s).isEmpty());


	}
}


class TrieNode {
	TrieNode [] nodes = new TrieNode[26];
	int count;

	public  TrieNode getChar(char c){
		if(nodes[c-'a']==null){
			nodes[c-'a'] = new TrieNode();
			count++;
		}
		return nodes[c-'a'];
	}

	public  void print(){
	}
}
