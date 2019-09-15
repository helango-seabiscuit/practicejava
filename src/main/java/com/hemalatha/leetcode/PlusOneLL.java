package com.hemalatha.leetcode;


class ListNode {
   int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class PlusOneLL {

	public ListNode plusOne(ListNode head) {
        int res = plusOneRec(head);
        if(res > 0){
        	ListNode l = new ListNode(res);
        	l.next = head;
        	head = l;
		}
		return head;
	}

	public int plusOneRec(ListNode h){
		if(h == null){
			return 0;
		}
		if(h.next == null){
			int val = h.val +1;
			h.val = val %10;
			return  val/10;
		}
		int r = plusOneRec(h.next);
		int val = h.val + r;
		h.val = val %10;
		return val/10;
	}
}
