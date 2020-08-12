package com.leetcode;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * @link https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
	}

	public int findUnsortedSubarray(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}

		int maxInArray = Integer.MIN_VALUE, minInArray = Integer.MAX_VALUE;
		int startPointer = -1, endPointer = -1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				minInArray = Math.min(minInArray, nums[i]);
			}
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) {
				maxInArray = Math.max(maxInArray, nums[i]);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > minInArray) {
				startPointer = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < maxInArray) {
				endPointer = i;
				break;
			}
		}
		if (startPointer == -1) {
			return 0;
		}

		return endPointer - startPointer + 1;
	}

}
