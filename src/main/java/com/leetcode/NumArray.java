package com.leetcode;

/**
 * 303. Range Sum Query
 * @link https://leetcode.com/problems/range-sum-query-immutable/tabs/description
 *
 * @author wangjf
 * @date 2017 - 07 - 29 0:02
 */
public class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        int sum = 0;
        dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return i == 0? dp[j]: dp[j] - dp[i-1];
    }

}
