package com.hemalatha.leetcode;

import java.util.Stack;

public class StackSequenceValidation {

	Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		StackSequenceValidation sequenceValidation = new StackSequenceValidation();
		System.out.println(sequenceValidation.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
		System.out.println(sequenceValidation.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		int pushPtr = 0;
		int popPtr = 0;
		if(pushed.length != popped.length){
			return false;
		}
		for(;pushPtr < pushed.length;pushPtr++){
			stack.push(pushed[pushPtr]);

			while (!stack.isEmpty() && popPtr < popped.length && stack.peek() == popped[popPtr]){
				stack.pop();
				popPtr++;
			}
		}

		return stack.isEmpty() && pushPtr == pushed.length && popPtr == popped.length;


	}
}
