package com.hemalatha.interview.List;

public class Node {

	private int value;
	private Node next;
	private Node previous;
	
	public Node(int value){
		this.value=value;
		this.next=this.previous=null;
	}
	public int getValue() {
		return value;
	}
	public Node getNext() {
		return next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
}
