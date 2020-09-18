package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [86] Partition List
 *
 * @link https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {

    public static void main(String[] args) {
        // 1 4 3 2 5 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = new PartitionList().partition(head, 3);
        System.out.println(result);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode firstPart = new ListNode();
        ListNode secondPart = new ListNode();
        ListNode resultIdx = firstPart;
        ListNode secondPartIdx = secondPart;

        while (head != null) {
            if (head.val < x) {
                firstPart.next = new ListNode(head.val);
                firstPart = firstPart.next;
            } else {
                secondPart.next = new ListNode(head.val);
                secondPart = secondPart.next;
            }
            head = head.next;
        }
        firstPart.next = secondPartIdx.next;

        return resultIdx.next;
    }

}
