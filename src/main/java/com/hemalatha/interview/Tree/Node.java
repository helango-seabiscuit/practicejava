package com.hemalatha.interview.Tree;

public class Node {

	private int value;
	private Node left;
	private Node right;
	
	public Node(int value){
		this.value=value;
		this.left=this.right=null;
	}
	public int getValue() {
		return value;
	}
	public Node getRight() {
		return left;
	}
	public Node getLeft() {
		return right;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setRight(Node next) {
		this.left = next;
	}
	public void setLeft(Node previous) {
		this.right = previous;
	}
	
}
