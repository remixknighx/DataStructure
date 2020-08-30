package com.leetcode.easy;

/**
 * [1413] Minimum Value to Get Positive Step by Step Sum
 * @link https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
 */
public class MinStartValue {

    public static void main(String[] args) {

    }

    public int minStartValue(int[] nums) {
        int minSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < minSum) {
                minSum = sum;
            }
        }
        if (minSum >= 0) {
            return 1;
        } else {
            return 1 + Math.abs(minSum);
        }
    }

}
