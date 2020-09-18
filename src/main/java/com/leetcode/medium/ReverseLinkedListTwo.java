package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [92] Reverse Linked List II
 *
 * @link https://leetcode.com/problems/reverse-linked-list-ii/description/
 */
public class ReverseLinkedListTwo {

    private ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reversedList = new ReverseLinkedListTwo().reverseBetween(head, 2, 4);
        System.out.println(reversedList);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode lastNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return lastNode;
    }

}
