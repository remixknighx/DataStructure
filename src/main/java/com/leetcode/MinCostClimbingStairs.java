package com.leetcode;

/**
 * 746. Min Cost Climbing Stairs
 * @link https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {


	public static void main(String[] args) {
		int[] cost = {10, 15, 20};

	}

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min((dp[i - 1] + cost[i]), (dp[i - 2] + cost[i]));
		}
		return Math.min(dp[n - 1], dp[n - 2]);

	}


}
