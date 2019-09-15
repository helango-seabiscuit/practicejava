package com.hemalatha.interview.List;

public class DoublyLinkedList {

	private Node head;
	private int size;

	public Node addNodeAtEnd(int value) {
		Node n = new Node(value);
		size++;
		if (head == null) {
			head = n;
			return n;
		}
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		n.setPrevious(temp);
		temp.setNext(n);
        return n;
	}

	public void addNodeAtStart(int value) {
		Node n = new Node(value);
		size++;
		if (head == null) {
			head = n;
			return;
		}
		n.setNext(head);
		head.setPrevious(n);
		head = n;

	}

	public void addNodeAtPosition(int value, int position) {
		Node n = new Node(value);
		int pos = 1;
		Node temp = head;
		if (position == 1)
			addNodeAtStart(value);
		else if (position == size+1)
			addNodeAtEnd(value);
		else {
			while (pos < position) {
				temp = temp.getNext();
				pos++;
			}
			n.setNext(temp);
			n.setPrevious(temp.getPrevious());
			temp.getPrevious().setNext(n);
			temp.setPrevious(n);
			size++;
		}
		

	}

	public Node getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getNode(int value) {
		Node temp=head;
		while(temp!=null){
			if(temp.getValue()==value)
				return temp;
			temp=temp.getNext();
		}
		return temp;

	}

	public Node getNodeAt(int position) {
		return null;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;

		return false;
	}
	
	public void traverseForward(){
		Node temp=head;
		while(temp!=null){
			System.out.print(" "+temp.getValue()+" ");
			temp=temp.getNext();
		}
	}
	
	public void getBackNode(){
		Node temp=head;
		while(temp!=null){
			System.out.println("Previous: "+temp.getPrevious().getValue()+" current:"+temp.getValue()+" ");
			temp=temp.getNext();
		}
	}

}
