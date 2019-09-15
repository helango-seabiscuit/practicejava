package com.hemalatha.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses parentheses = new ValidParentheses();
		System.out.println(parentheses.isValid("()"));//true
		System.out.println(parentheses.isValid("()[]{}"));//true
		System.out.println(parentheses.isValid("(]"));//false
		System.out.println(parentheses.isValid("([)]"));//false
		System.out.println(parentheses.isValid("{[]}"));//true
	}

	public boolean isValid(String s) {
         if(s==null || s.isEmpty()){
         	return true;
		 }

		 char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
         for(Character c:arr){
         	if(c == '(' || c=='{' || c=='['){
         		stack.push(c);
			}else {
         		if(!stack.isEmpty()) {
					char st = stack.pop();
					if (st == '(' && c != ')' || (st == '{' && c != '}') || (st == '[' && c != ']')) {
						return false;
					}
				}else{
         			return false;
				}
			}
		 }
		 return true;
	}
}
