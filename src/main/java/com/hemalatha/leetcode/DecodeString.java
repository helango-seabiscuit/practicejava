package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		DecodeString decodeString = new DecodeString();
		System.out.println(decodeString.decodeString("3[a]2[bc]"));
		System.out.println(decodeString.decodeString("3[a2[c]]"));
		System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
//		System.out.println(decodeString.decodeString("100[leetcode]"));


	}

	public String decodeString(String s) {

		Stack<String> st = new Stack<>();

		for(Character a:s.toCharArray()){
			if(a !=']'){
				st.push(String.valueOf(a));
			}else{
				StringBuilder sb = new StringBuilder();
				while (!st.isEmpty() ){
					if(st.peek().equals("[")){
						break;
					}
					sb.insert(0,st.pop());
				}
				st.pop();
				int t = getValue(st);
				StringBuilder res = new StringBuilder();
				while (t>0){
					res.append(sb.toString());
					t--;
				}
				st.push(res.toString());
			}
		}
		StringBuilder r = new StringBuilder();
		while (!st.isEmpty()){
			r.insert(0,st.pop());
		}
		return r.toString();
	}

	private int getValue(Stack<String> st){
		String res = "";
		while(!st.isEmpty()){
			try{
				Integer.valueOf(st.peek());
				res =st.pop()+res;
			}catch (Exception e){
				break;
			}
		}
		return Integer.valueOf(res);
	}
}
