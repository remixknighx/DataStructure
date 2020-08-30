package com.leetcode.easy;

/**
 * 160. Intersection of Two Linked Lists
 * @link https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class IntersectionOf2Lists {

    public static void main(String[] args) {
        ListNode head3 = new ListNode(6);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(8);
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = head3;
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = head3;

        ListNode commonList = new IntersectionOf2Lists().getIntersectionNode(head1, head2);
        System.out.println(commonList.val);
        while (commonList.next != null) {
            commonList = commonList.next;
            System.out.println(commonList.val);
        }
    }

    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }

    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
