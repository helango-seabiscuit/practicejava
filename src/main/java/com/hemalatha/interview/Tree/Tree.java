package com.hemalatha.interview.Tree;

import java.util.Stack;

public class Tree {

	Node root;

	public void buildTree() {
		addNode(8);
		addNode(4);
		addNode(2);
		addNode(10);
		addNode(12);
		addNode(9);
		addNode(1);
		addNode(14);
		inOrderRecurTraverse(root);
	}

	public void addNode(int value) {
		Node n = new Node(value);
		if (root == null) {
			root = n;
			return;
		}
		Node temp = root;
		while (temp != null) {
			if (value < temp.getValue()) {
				if (temp.getLeft() == null) {
					temp.setLeft(n);
					return;
				}
				temp = temp.getLeft();
			} else {
				if (temp.getRight() == null) {
					temp.setRight(n);
					return;
				}
				temp = temp.getRight();
			}
		}

	}

	public void inOrderRecurTraverse(Node curr) {
		if (curr == null)
			return;
		inOrderRecurTraverse(curr.getLeft());
		System.out.print(" " + curr.getValue() + " ");
		inOrderRecurTraverse(curr.getRight());
	}

	public void zigZagDisplay(Node curr) {
		Stack<Node> s = new Stack<Node>();
		Stack<Node> temp = new Stack<Node>();
		boolean leftToRight = true;		
		s.push(curr);
		do {
			while (!s.isEmpty()) {
				Node now = s.pop();
				System.out.print(" " + now.getValue() + " ");
				Node left = now.getLeft();
				Node right = now.getRight();
				if (left != null)
					temp.push(left);
				if (right != null)
					temp.push(right);

			}
			if (leftToRight){
				while (!temp.isEmpty())
					s.push(temp.pop());
				leftToRight = false;
			}				
			else{
				leftToRight = true;
				Stack<Node> t=new Stack<Node>();
				while(!temp.isEmpty())
				t.push(temp.pop());
				while(!t.isEmpty())
					s.push(t.pop());
			} 
			
		} while (!s.isEmpty());
	}

}
