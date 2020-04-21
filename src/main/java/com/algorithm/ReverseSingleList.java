package com.algorithm;

/**
 * 反转单向链表有递归和迭代两种实现方式
 */
public class ReverseSingleList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(6);
        listNode.next.next.next.next = new ListNode(7);
        IterateReverse iterateReverse = new IterateReverse();
//        ListNode reversedList = recursiveReverse.reverseN(listNode, 3);
        ListNode reversedList = iterateReverse.reverseList(listNode, 1, 4);
        System.out.println(reversedList);
    }

}

/**
 * 迭代反转
 * 时间复杂度为O(N),空间复杂度为O(1)
 */
class IterateReverse {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode result = null;

        while(p != null) {
            ListNode tmp = p.next;
            p.next = result;
            result = p;
            p = tmp;
        }

        return result;
    }

    /**
     * 反转前n个节点
     */
    public ListNode reverseList(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode firstNode = head;
        ListNode result = null;

        while (n > 0) {
            ListNode tmpNode = p.next;
            p.next = result;
            result = p;
            p = tmpNode;
            n--;
        }

        firstNode.next = p;

        return result;
    }

    /**
     * 反转区间[m, n]的节点
     *
     */
    public ListNode reverseList(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (m == 1) {
            return reverseList(head, n);
        }

        ListNode lastNode = new ListNode(head.val);
        ListNode result = lastNode;
        ListNode p = head;
        while (m > 0) {
            m--;
            n--;
            p = p.next;
            if (m == 1) {
                break;
            }
            lastNode.next = new ListNode(p.val);
            lastNode = lastNode.next;
        }
        lastNode.next = reverseList(p, n);
        return result;
    }

}

/**
 * 递归反转
 * 时间及空间复杂度均为O(N)
 */
class RecursiveReverse {

    private ListNode successor = null;

    /**
     * 本方法通过递归的方式反转单向链表
     */
    public ListNode recursiveReverseListNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode lastNode = recursiveReverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode lastNode = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return lastNode;
    }

    /**
     * 反转链表的一部分
     * 索引区间为[m,n]
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
