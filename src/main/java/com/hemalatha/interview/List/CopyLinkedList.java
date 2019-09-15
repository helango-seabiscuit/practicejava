package com.hemalatha.interview.List;

public class CopyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// setting the current doubly linked list by making previous pointers
		// pointing to different random nodes
		DoublyLinkedList dbl = new DoublyLinkedList();
		dbl.addNodeAtEnd(2);
		dbl.addNodeAtEnd(3);
		dbl.addNodeAtEnd(4);
		dbl.addNodeAtEnd(5);
		// dbl.traverseForward();

		makeRedundant(dbl);
		setPreviousNode(dbl.getNode(2), 4, dbl);
		setPreviousNode(dbl.getNode(3), 2, dbl);
		setPreviousNode(dbl.getNode(4), 5, dbl);
		setPreviousNode(dbl.getNode(5), 3, dbl);

	//	dbl.getBackNode();
		

		// Make a copy of the currently existing list;
		Node newHeader=copyLinkedList(dbl);
		System.out.println("Old Nodes");
		dbl.getBackNode();
		System.out.println("new Copied Nodes");
		dbl.setHead(newHeader);
		dbl.getBackNode();
		
	}

	public static void setPreviousNode(Node current, int value,
			DoublyLinkedList dbl) {
		Node prev = dbl.getNode(value);
		current.setPrevious(prev);

	}

	public static void makeRedundant(DoublyLinkedList dbl) {
		dbl.addNodeAtPosition(2, 2);
		dbl.addNodeAtPosition(3, 4);
		dbl.addNodeAtPosition(4, 6);
		dbl.addNodeAtPosition(5, 8);
	}

	public static Node copyLinkedList(DoublyLinkedList dbl) {
		Node temp = dbl.getHead();
		temp = temp.getNext();
		Node newHeader = temp;
		while (temp != null) {
			temp.setPrevious(temp.getPrevious().getPrevious().getNext());
			temp = temp.getNext();
			if (temp != null)
				temp = temp.getNext();
		}
      
		temp = dbl.getHead();
		while (temp != null) {
			Node t = temp.getNext();
			if (temp.getNext() != null)
				temp.setNext(temp.getNext().getNext());
			else
				temp.setNext(temp.getNext());
			temp = t;

		}
		return newHeader;
	}

}
