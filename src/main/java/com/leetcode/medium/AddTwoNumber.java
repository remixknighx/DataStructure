package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * [2] Add Two Numbers
 * @link https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l1Idx = l1;
        ListNode l2Idx = l2;

        ListNode resultIdx = result;
        int lastNodeRemain = 0;
        while (true) {
            if (l1Idx == null) {
                resultIdx.val = l2Idx.val;
                l2Idx = l2Idx.next;
            } else if (l2Idx == null) {
                resultIdx.val = l1Idx.val;
                l1Idx = l1Idx.next;
            } else {
                resultIdx.val = l1Idx.val + l2Idx.val;
                l1Idx = l1Idx.next;
                l2Idx = l2Idx.next;
            }

            resultIdx.val += lastNodeRemain;
            lastNodeRemain = 0;

            if (resultIdx.val >= 0) {
                lastNodeRemain = resultIdx.val / 10;
                resultIdx.val = resultIdx.val % 10;
            }

            if (l1Idx == null && l2Idx == null) {
                if (lastNodeRemain != 0) {
                    resultIdx.next = new ListNode(lastNodeRemain);
                }
                break;
            } else {
                resultIdx.next = new ListNode();
                resultIdx = resultIdx.next;
            }
        }

        return result;
    }

}
