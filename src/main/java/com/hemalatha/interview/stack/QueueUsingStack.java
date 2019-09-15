package com.hemalatha.interview.stack;

import java.util.Stack;

public class QueueUsingStack {

	public static void main(String args[]){
		Queue<Integer> q=new Queue<Integer>();
		q.queue(2);
		q.queue(5);
		q.queue(10);
		q.queue(16);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());		
		
		
	}
}


class Queue<T> {
	Stack<T> input;
	Stack<T> output;
	
	Queue(){
		input=new Stack<T>();
		output=new Stack<T>();
	}
	
	public void queue(T item){
		input.push(item);
	}
	
	
	public T dequeue(){
		if(output.isEmpty()){
			while(!input.isEmpty()){
				output.push(input.pop());
			}
		}
		return output.pop();
	}
}
