package com.leetcode.easy;

/**
 * 198. House Robber
 * @link https://leetcode.com/problems/house-robber/#/discuss
 *
 * @author wangjf
 * @date 2017 - 07 - 20 17:26
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 1};
        System.out.println(new HouseRobber().rob(nums));
    }

    public int rob(int[] nums) {
        // write your code here
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        int[] res = new int[n+1];

        res[0] = 0;
        res[1] = nums[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i-1]);
        }

        return res[n];
    }
}
