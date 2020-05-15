package com.algorithm;

/**
 * 判断回文链表
 *
 * @author wangjianfeng
 */
public class PalindromeListNodeMain {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);

        System.out.println(new TwoPointerPalindrome().isPalindrome(head2));
        System.out.println(new PalindromeListNode().isPalindrome(head2));

    }

}

/**
 * 把链表节点放入一个栈，然后再拿出来，这时候元素顺序就是反的，只不过我们利用的是递归函数的堆栈而已
 * 时间和空间复杂度都是O(N)
 */
class PalindromeListNode {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}

/**
 * 通过双指针算法判断回文链表
 * 时间复杂度O(N) 空间复杂度O(1)
 */
class TwoPointerPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = traverse(slow);

        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }

        return true;
    }

    /**
     * 反转链表
     */
    private ListNode traverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmpNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmpNode;
        }
        return pre;
    }

}
