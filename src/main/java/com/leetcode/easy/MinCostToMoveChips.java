package com.leetcode.easy;

/**
 * [1217] Minimum Cost to Move Chips to The Same Position
 * @link https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 */
public class MinCostToMoveChips {


    public int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for (int chip : position) {
            ++cnt[chip % 2];
        }
        return Math.min(cnt[0], cnt[1]);
    }
}
