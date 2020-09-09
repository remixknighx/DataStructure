package com.leetcode.medium;

/**
 * [33] Search in Rotated Sorted Array
 * @link https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchedInRotateSortedArray {

    public static void main(String[] args) {
    }

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }

    public int helper(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        } else {
            int q = (left + right) / 2;
            if (nums[left] <= nums[q]) {
                if (nums[left] <= target && target <= nums[q]) {
                    return helper(nums, left, q, target);
                } else {
                    return helper(nums, q + 1, right, target);
                }
            } else {
                if (nums[q + 1] <= target && target <= nums[right]) {
                    return helper(nums, q + 1, right, target);
                } else {
                    return helper(nums, left, q, target);
                }
            }
        }
    }
}
