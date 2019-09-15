package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

	private Set<String> res = new HashSet<>();

	public static void main(String[] args) {
		GenerateParenthesis parenthesis = new GenerateParenthesis();
		for(String s:parenthesis.generateParenthesis(3)){
			//System.out.println(s);
		};
	}

	public List<String> generateParenthesis(int n) {
        genParenthesis("",0,0,n);
        List<String> l = new ArrayList<>();
        for(String s:res){
        	l.add(s);
		}
		return l;
	}

	public void genParenthesis(String l,int open, int close,int n) {
		if (close == n) {
			res.add(l);
			return;
		}
		if (open < n){
			System.out.println(open +" ,"+close);
			genParenthesis(l + "(", open+1,close,n);
	     }
	     if(close<open) {
			 System.out.println(open + " ," + close);
			 genParenthesis(l + ")", open, close + 1, n);
		 }
		}

}
