package com.leetcode.easy;

/**
 * 141. Linked List Cycle
 * @link https://leetcode.com/problems/linked-list-cycle/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
