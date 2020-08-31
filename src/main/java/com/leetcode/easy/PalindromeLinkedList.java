package com.leetcode.easy;

import com.leetcode.ListNode;

/**
 * 234. Palindrome Linked List
 * @link https://leetcode.com/problems/palindrome-linked-list/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 24 21:59
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        PalindromeLinkedList palLinkedList = new PalindromeLinkedList();
        System.out.println(palLinkedList.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }


}
