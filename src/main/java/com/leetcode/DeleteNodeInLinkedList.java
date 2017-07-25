package com.leetcode;

/**
 * 237. Delete Node in a Linked List
 * @link https://leetcode.com/problems/delete-node-in-a-linked-list/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 25 21:02
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
