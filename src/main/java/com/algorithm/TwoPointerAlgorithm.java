package com.algorithm;

/**
 * 双指针算法
 * 快慢指针：主要解决链表中的问题，比如典型的判定链表中是否包含环
 * 左右指针：主要解决数组（或者字符串）中的问题，比如二分查找
 * @author wangjianfeng
 */
public class TwoPointerAlgorithm {

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        firstNode.next = new ListNode(2);
        firstNode.next.next = new ListNode(3);
        firstNode.next.next.next = new ListNode(4);
        firstNode.next.next.next.next = firstNode;
        System.out.println(firstNode);
    }

    /**
     * 快慢指针，判断这个链表是否有环
     */
    private static boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
