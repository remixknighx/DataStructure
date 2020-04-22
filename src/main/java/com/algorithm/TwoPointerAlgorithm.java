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

}

/**
 * 快慢指针
 */
class FastSlowAlgorithm {

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

    /**
     * 查找环起点
     */
    private static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上面的代码类似 hasCycle 函数
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 查找中间节点
     * 当快指针到达链表尽头时，慢指针就处于链表的中间位置。
     */
    private static ListNode findMidNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 就在中间位置
        return slow;
    }

    /**
     * 寻找链表的倒数第k个元素
     * 让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点
     */
    private static ListNode findLastKNode(ListNode head, int k) {
        ListNode slow, fast;
        slow = fast = head;
        while (k-- > 0)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}

/**
 * 左右指针
 */
class LeftRightAlgorithm {

    /**
     * 二分查找
     */
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    /**
     * 从一个升序数组中找到两个数满足target
     */
    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            } else {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 反转数组
     */
    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // swap(nums[left], nums[right])
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}


















