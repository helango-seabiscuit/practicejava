package com.hemalatha.IK.LinkedList;

public class ReverseLL {

	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node r = new Node(4);
		Node s = new Node(8);
		Node t = new Node(12);
		Node u = new Node(16);
		r.next = s;
		s.next = t;
		t.next = u;
		u.next = null;
		Node res = reverse(r);
		while (res != null){
			System.out.print(res.val+" ");
			res = res.next;
		}
	}

	public static Node reverse(Node head){
		Node previous = null;
		Node current = head;
		Node next = head;

		while (current != null){
			next = next.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}
}
