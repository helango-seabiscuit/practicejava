package com.hemalatha.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class DeleteDuplicateNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        DeleteDuplicateNodes deleteDuplicateNodes = new DeleteDuplicateNodes();
        ListNode res = deleteDuplicateNodes.deleteDuplicates(head);
        while (res != null) {
            System.out.print(head.val + " ->");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head); //use sentinel to cover edge cases
        ListNode pred = sentinel;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = head;
            }

            head = head.next;
        }
        return sentinel.next;
    }
}
