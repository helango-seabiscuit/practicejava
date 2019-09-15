package com.hemalatha.leetcode;

import java.util.Stack;

public class BaseBallGame {

	public static void main(String[] args) {
		BaseBallGame game = new BaseBallGame();
		System.out.println(game.calPoints(new String[]{"5","2","C","D","+"}));//30
		System.out.println(game.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));//27
	}

	public int calPoints(String[] ops) {
		int result = 0;
		Stack<Integer> st = new Stack<>();
		for(String op: ops){
			switch (op){
				case "D": int lastPoint = st.peek();
				          st.push(lastPoint*2);
				          result +=lastPoint*2;
				          break;
				case "C": int cancelpt = st.pop();
				          result -= cancelpt;
				          break;
				case "+": int pt1 = st.pop();
				          int pt2 = st.pop();
				          int newpt = pt1+pt2;
				          result += newpt;
				          st.push(pt2);
				          st.push(pt1);
				          st.push(newpt);
				          break;
				default:
					      int t = Integer.valueOf(op);
					      st.push(t);
					      result +=t;

			}
		}
		return result;
	}
}
