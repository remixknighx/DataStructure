package com.algorithm;

/**
 * 去除有序数组中的重复元素
 * 使用快慢指针
 */
public class RemoveDupElements {

	public static void main(String[] args) {
	}

	/**
	 * 去除数组中的重复元素并返回新数组的长度
	 */
	static int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int slow = 0, fast = 1;
		while (fast < n) {
			if (nums[fast] != nums[slow]) {
				slow++;
				// 维护 nums[0..slow] 无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 长度为索引 + 1
		return slow + 1;
	}

	/**
	 * 去除链表中的重复元素并返回新链表
	 */
	static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			if (fast.val != slow.val) {
				// nums[slow] = nums[fast];
				slow.next = fast;
				// slow++;
				slow = slow.next;
			}
			// fast++
			fast = fast.next;
		}
		// 断开与后面重复元素的连接
		slow.next = null;
		return head;
	}
}
