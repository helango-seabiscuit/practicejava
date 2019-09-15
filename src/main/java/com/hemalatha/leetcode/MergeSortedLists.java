package com.hemalatha.leetcode;

public class MergeSortedLists {

	public static void main(String[] args) {
       ListNode a = new ListNode(1);
       ListNode b = new ListNode(2);
       ListNode c = new ListNode(4);
       ListNode d = new ListNode(1);
       ListNode e = new ListNode(3);
       ListNode f = new ListNode(4);

       a.next=b;
       b.next=c;

       d.next=e;
       e.next=f;
       MergeSortedLists lists = new MergeSortedLists();
       ListNode res =lists.mergeTwoLists(a,d);

       while (res !=null){
		   System.out.print(res.val +" ");
		   res = res.next;
	   }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}