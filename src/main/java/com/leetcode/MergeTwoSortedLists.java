package com.leetcode;

/**
 * 将两个有序的链表合并成一个有序的链表
 * 参考：@link http://www.lintcode.com/zh-cn/problem/merge-two-sorted-lists/
 * 21. Merget Two Sorted Lists
 * @link https://leetcode.com/problems/merge-two-sorted-lists/#/description
 *
 * @author wangjf
 * @date 2017/7/5.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode nodeOne, ListNode nodeTwo) {

        if (nodeOne == null && nodeTwo == null) {
            return null;
        } else if (nodeOne == null) {
            return nodeTwo;
        } else if (nodeTwo == null) {
            return  nodeOne;
        }

        ListNode lastNode = new ListNode(0);
        ListNode result = lastNode;
        while (nodeOne != null && nodeTwo != null) {
            if(nodeOne.val < nodeTwo.val) {
                lastNode.val = nodeOne.val;
                nodeOne = nodeOne.next;
            } else {
                lastNode.val = nodeTwo.val;
                nodeTwo = nodeTwo.next;
            }

            lastNode.next = new ListNode(0);
            lastNode = lastNode.next;
        }

        if (nodeOne != null) {
            lastNode.val = nodeOne.val;
            lastNode.next = nodeOne.next;
        }

        if (nodeTwo != null) {
            lastNode.val = nodeTwo.val;
            lastNode.next = nodeTwo.next;
        }

        return result;
    }
}
