package com.leetcode.easy;

import java.util.Arrays;

/**
 * [1033] Moving Stones Until Consecutive
 * @link https://leetcode.com/problems/moving-stones-until-consecutive/description/
 */
public class NumMoveStones {

    public static void main(String[] args) {
        int[] result1 = numMovesStones(1, 2, 5);
        int[] result2 = numMovesStones(4, 3, 2);
        int[] result3 = numMovesStones(3, 5, 1);
        System.out.println(result1);
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);

        if (nums[2] - nums[0] == 2) {
            return new int[]{0, 0};
        } else {
            return new int[]{Math.min(nums[1] - nums[0], nums[2] - nums[1]) <= 2 ? 1 : 2, nums[2] - nums[0] - 2};
        }

    }

}
