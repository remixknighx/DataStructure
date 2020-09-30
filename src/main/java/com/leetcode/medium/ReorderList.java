package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [143] Reorder List
 * @link https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new ReorderList().reverse(head);
        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode lastNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null) {
                break;
            }

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

}
