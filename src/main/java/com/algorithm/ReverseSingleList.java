package com.algorithm;

/**
 * 反转单向链表有递归和迭代两种实现方式
 */
public class ReverseSingleList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
    }

    /**
     * 本方法通过递归的方式反转单向链表
     */
    private ListNode recursiveReverseListNode(ListNode head) {
        return null;
    }

    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     */
    ListNode reverseN(ListNode head, int n) {
        return null;
    }

    /**
     * 反转链表的一部分
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        return null;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
