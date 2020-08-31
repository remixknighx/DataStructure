package com.leetcode.easy;

import com.leetcode.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * @link https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 *
 * @author wangjf
 * @date 2017/7/12.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val){
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }

}
