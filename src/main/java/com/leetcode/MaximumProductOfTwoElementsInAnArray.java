package com.leetcode;

import java.util.Arrays;

/**
 * 1464. Maximum Product of Two Elements in an Array
 * @link https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * @author wangjianfeng
 */
public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 5};
        System.out.println(new MaximumProductOfTwoElementsInAnArray().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

}
