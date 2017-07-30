package com.leetcode;

/**
 * 53. Maximum Subarray
 * @link https://leetcode.com/problems/maximum-subarray/#/description
 *
 * @author wangjf
 * @date 2017/7/10.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, -3, -4, -1, -2, -1, -5};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

}
