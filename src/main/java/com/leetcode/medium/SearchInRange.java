package com.leetcode.medium;

/**
 * [34] Find First and Last Position of Element in Sorted Array
 * @link https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class SearchInRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(firstLowerEqual(nums, target));
        System.out.println(firstGreaterEqual(nums, target+1));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstLowerEqual(nums, target)};
    }

    /**
     * find the first number that is greater than or equal to target.
     * could return A.length if target is greater than A[A.length-1].
     */
    private static int firstGreaterEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

    private static int firstLowerEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (target < nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high-1;
    }

}
