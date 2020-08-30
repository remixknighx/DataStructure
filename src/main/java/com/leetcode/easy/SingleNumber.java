package com.leetcode.easy;

/**
 * 136, Single Number
 * @link https://leetcode.com/problems/single-number/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

}
