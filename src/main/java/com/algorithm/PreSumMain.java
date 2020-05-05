package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和算法
 *
 * @author wangjianfeng
 */
public class PreSumMain {

    public static void main(String[] args) {
        int[] sums = {1, 1, 1};
        int k = 2;
        System.out.println(subArraySum(sums, k));
    }

    /**
     * 给定一个整数数组和一个整数k，找到该数组中和为k的连续的子数组的个数
     */
    private static int subArraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }

        return ans;
    }

}
