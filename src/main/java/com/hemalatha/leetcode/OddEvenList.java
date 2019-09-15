package com.hemalatha.leetcode;

public class OddEvenList {

	public static void main(String[] args) {
		OddEvenList oddEvenList = new OddEvenList();
		ListNode res= null;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		oddEvenList.print(n1);
//		res = oddEvenList.oddEvenList(n1);
//		oddEvenList.print(res); //1,3,5,2,4

		//2->1->3->5->6->4->7-
		n1 = new ListNode(1);
		n2 = new ListNode(2);
		n3 = new ListNode(3);
		n4 = new ListNode(4);
		n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);

		n2.next = n1;
		n1.next = n3;
		n3.next = n5;
		n5.next = n6;
		n6.next = n4;
		n4.next = n7;
		oddEvenList.print(n2);
		res = oddEvenList.oddEvenList(n2);
		oddEvenList.print(res);//2->3->6->7->1->5->4

	}

	private void print(ListNode head){
		System.out.println();
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		ListNode oddPtr = head;
		ListNode evenPtr = head.next;
		ListNode evenPointer = head.next;
		ListNode curr = evenPtr.next;
		int i=1;
		while (curr != null){
			if(i%2 == 1){
				oddPtr.next = curr;
				oddPtr = curr;
			}else{
				evenPtr.next = curr;
				evenPtr = curr;
			}
			curr = curr.next;
			i++;
		}

		oddPtr.next = evenPointer;
		evenPtr.next = null;
		return head;

	}
}


