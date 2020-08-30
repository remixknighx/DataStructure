package com.leetcode.easy;

/**
 * 1. Two Sum
 * @link https://leetcode.com/problems/two-sum/#/description
 *
 * @author wangjf
 * @date 2017/6/24 0024.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = twoSum(nums, target);

        System.out.println("Index One is: " + indices[0] + " Index Two is: " + indices[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }

        return indices;
    }
}
