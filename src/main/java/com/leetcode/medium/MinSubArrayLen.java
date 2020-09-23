package com.leetcode.medium;

/**
 * [209] Minimum Size Subarray Sum
 *
 * @link https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
//        int[] nums = {2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(213, nums));
    }

    /**
     * 滑动窗口算法
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE? 0: result;
    }

}
