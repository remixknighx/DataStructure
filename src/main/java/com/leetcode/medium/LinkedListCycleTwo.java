package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [142] Linked List Cycle II
 *
 * @link https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycleTwo {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        ListNode result = new LinkedListCycleTwo().detectCycle(head);
        System.out.println(result);
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

}
