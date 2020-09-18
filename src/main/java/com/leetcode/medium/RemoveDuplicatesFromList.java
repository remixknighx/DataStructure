package com.leetcode.medium;

import com.leetcode.ListNode;
import com.sun.org.apache.regexp.internal.RE;

/**
 * [82] Remove Duplicates from Sorted List II
 * @link https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class RemoveDuplicatesFromList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new RemoveDuplicatesFromList().deleteDuplicates(listNode);
        System.out.println(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

}
