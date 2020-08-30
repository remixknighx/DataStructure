package com.leetcode.easy;

import java.util.ArrayList;

/**
 * 206. Reverse Linked List
 * @link https://leetcode.com/problems/reverse-linked-list/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 23 20:53
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversedHead = reverseLinkedList.reverseList(head);

        while (reversedHead != null) {
            System.out.println(reversedHead.val);
            reversedHead = reversedHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode reversedHead = new ListNode(0);
        ListNode temp = reversedHead;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        return reversedHead.next;
    }

}
