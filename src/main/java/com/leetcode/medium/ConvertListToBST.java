package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

/**
 * [109] Convert Sorted List to Binary Search Tree
 * @link https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertListToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode result = new ConvertListToBST().sortedListToBST(head);
        System.out.println(result);

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {

        ListNode fast = head;
        ListNode slow = head;

        if (head == tail) {
            return null;
        }

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }

}
