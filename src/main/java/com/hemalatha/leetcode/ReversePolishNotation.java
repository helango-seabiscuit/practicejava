package com.hemalatha.leetcode;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		ReversePolishNotation polishNotation = new ReversePolishNotation();
		System.out.println(polishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));//9
		System.out.println(polishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));//6
		System.out.println(polishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));//22
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> token = new Stack<>();
		Set<String> operators = new HashSet<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");

		for(String t:tokens){
			if(operators.contains(t)){
				int r = Integer.valueOf(token.pop());
				int l = Integer.valueOf(token.pop());
				switch (t){
					case "+":token.push(l+r);break;
					case "-":token.push(l-r);break;
					case "*":token.push(l*r);break;
					case "/":token.push(l/r);break;
				}
			}else{
				token.push(Integer.valueOf(t));
			}
		}
        return token.pop();

	}
}
