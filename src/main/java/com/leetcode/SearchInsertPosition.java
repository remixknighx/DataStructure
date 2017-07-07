package com.leetcode;

/**
 * 38. Search Insert Position
 * @link https://leetcode.com/problems/search-insert-position/#/description
 *
 * @author wangjf
 * @date 2017/7/7.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            if (target < nums[i-1]){
                return 0;
            } else if (target == nums[i-1]){
                return i-1;
            } else if (target > nums[i-1] && target < nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

}
