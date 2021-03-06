package com.leetcode.easy;

/**
 * @author wangjf
 * @date 2017/7/11.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int stairs = 13;
        System.out.println(new ClimbingStairs().climbStairs(stairs));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
