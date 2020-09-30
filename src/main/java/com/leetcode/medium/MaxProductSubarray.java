package com.leetcode.medium;

/**
 * [152] Maximum Product Subarray
 * @link https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, 3, 0, -3};
        System.out.println(new MaxProductSubarray().maxProduct(nums1));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length, res = nums[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }

}
