package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class ValidAddParenthesis {

	public static void main(String[] args) {
		ValidAddParenthesis addParenthesis = new ValidAddParenthesis();
		System.out.println(addParenthesis.minAddToMakeValid("()"));//0
		System.out.println(addParenthesis.minAddToMakeValid("())"));//1
		System.out.println(addParenthesis.minAddToMakeValid("((("));//3
		System.out.println(addParenthesis.minAddToMakeValid("()))((")); //4
	}

	public int minAddToMakeValid(String S) {
		Stack<Character> st = new Stack<>();
		char[] arr = S.toCharArray();
		for(Character c:arr){

			if(c=='('){
				st.add(c);
			}else{
				if(!st.isEmpty() && st.peek()=='('){
					st.pop();
				}else{
					st.add(c);
				}
			}
		}
		return st.size();
	}
}
