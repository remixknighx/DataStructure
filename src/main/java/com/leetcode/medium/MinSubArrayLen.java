package com.leetcode.medium;

import java.util.Arrays;

/**
 * [209] Minimum Size Subarray Sum
 *
 * @link https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(new MinSubArrayLen().minSubArrayLen(213, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int sum = 0;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            count++;
            if (sum >= s) {
                break;
            }
        }

        return count;
    }

}
