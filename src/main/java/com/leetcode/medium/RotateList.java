package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [61] Rotate List
 * @link https://leetcode.com/problems/rotate-list/description/
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        ListNode result = new RotateList().rotateRight(head, 2);
        System.out.println(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int listSize = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            listSize++;
            tempHead = tempHead.next;
        }

        k = k % listSize;
        ListNode result = head;
        ListNode idxNode = head;
        while (k!=0) {
            if (idxNode.next != null && idxNode.next.next == null) {
                idxNode.next.next = result;
                result = idxNode.next;
                idxNode.next = null;
                idxNode = result;
                k--;
            } else {
                idxNode = idxNode.next;
            }
        }
        return result;
    }

}
