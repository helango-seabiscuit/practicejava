package com.hemalatha.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "applepineapple";
		Set<String> dict = new HashSet<>();
		dict.add("apple");
		dict.add("pine");
		dict.add("pineapple");
		List<String> r = wordBreak(s,dict);
		for (String st:r){
			System.out.println(st);
		}
	}

	public static   List<String> wordBreak(String s, Set<String> dict){
		List<String> result = new LinkedList<>();
		wordbreak(s,"",0,result,dict);
		return result;
	}

	public static void wordbreak(String orig, String path, int i, List<String> res, Set<String> dict){
		if(i==orig.length()){
			String[] s = path.split(" ");
			for(String st:s){
				if(!dict.contains(st)){
					return;
				}
			}
			res.add(path);
			return;
		}

		wordbreak(orig, path+orig.charAt(i),i+1,res,dict);
		wordbreak(orig, path+" "+orig.charAt(i),i+1,res,dict);
	}
}
