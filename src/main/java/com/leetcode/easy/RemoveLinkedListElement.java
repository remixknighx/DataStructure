package com.leetcode.easy;

/**
 * 203. Remove Linked List Elements
 * @link https://leetcode.com/problems/remove-linked-list-elements/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 20 19:14
 */
public class RemoveLinkedListElement {

    public static void main(String[] args) {
        ListNode list = new ListNode(6);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(6);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next.next = new ListNode(6);

        ListNode newList = new RemoveLinkedListElement().removeElements(list, 6);
        while (newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
