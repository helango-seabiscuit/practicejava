package com.hemalatha.jcg;

public class SortLL012 {


	public static void arrange(Node head){
		Node cp  = null;
		Node np = head;
		Node ptr = head;
		while (np!=null){

			if(np.data == 0){
				if(cp == null){
					cp = np;
					np = np.next;
					continue;
				}
				np.next = cp.next;
				cp.next = np;
				cp = np;
			}else if(np.data == 1){
				np = np.next;
			}
		}
	}

	static class Node{
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
