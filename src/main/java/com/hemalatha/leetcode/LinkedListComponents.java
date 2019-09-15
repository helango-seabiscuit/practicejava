package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

	public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

	public static void main(String[] args) {
		LinkedListComponents components = new LinkedListComponents();
	}

	public int numComponents(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for(Integer g:G){
			set.add(g);
		}

		int ans = 0;
		ListNode curr = head;
		while (curr != null){
			if(set.contains(curr.val) &&
					(curr.next ==null || !set.contains(curr.next.val)) ){
				ans++;
			}

			curr = curr.next;
		}

		return ans;
	}
}
