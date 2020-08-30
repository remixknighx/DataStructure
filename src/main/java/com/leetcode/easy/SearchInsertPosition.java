package com.leetcode.easy;

/**
 * 38. Search Insert Position
 * @link https://leetcode.com/problems/search-insert-position/#/description
 *
 * @author wangjf
 * @date 2017/7/7.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start + 1 < end) {
            middle = start + (end - start)/2;

            if (nums[middle] < target) {
                start = middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                return middle;
            }
        }

        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

}
