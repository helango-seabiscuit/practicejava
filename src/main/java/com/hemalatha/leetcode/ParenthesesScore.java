package com.hemalatha.leetcode;

import java.util.Stack;

public class ParenthesesScore {


	public static void main(String[] args) {
		ParenthesesScore score = new ParenthesesScore();
		System.out.println(score.scoreOfParentheses("()"));//1
		System.out.println(score.scoreOfParentheses("(())"));//2
		System.out.println(score.scoreOfParentheses("()()"));//2
		System.out.println(score.scoreOfParentheses("(()(()))"));//6
	}
	public int scoreOfParentheses(String S) {
		Stack<Character> st = new Stack<>();
		char[] arr = S.toCharArray();

		for(int i=0;i<arr.length;i++){
		  	char curr = arr[i];
			if(arr[i]== '('){
				st.push(curr);
			}
			if(curr ==')'){
				if(st.peek() =='('){
					st.pop();
					st.push('1');
				}else{
					int res = 0;
                  while(!st.isEmpty() && st.peek() !='('){
                  	res += st.peek() -'0';
                  	st.pop();
				  }
				  st.pop();
                  st.push((char)('0'+2*res));
				}

			}
		}

		if(st.size()>1){
			int res = 0;
			while(!st.isEmpty()){
				res += st.pop()-'0';
			}
			st.push((char)('0'+res));
		}
		return st.pop()-'0';
	}
}
