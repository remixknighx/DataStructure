package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [24] Swap Nodes in Pairs
 * @link https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = new SwapPairs().swapPairs(head);
        System.out.println(result);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}
