package com.leetcode.easy;

/**
 * 453. Minimum Moves to Equal Array Elements
 * @link https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * @author wangjf
 * @date 2018/2/16 0016.
 */
public class MinMoves {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8};
        System.out.println(new MinMoves().minMoves(nums));
    }

    private int minMoves(int[] nums) {
        int sumNum = 0;
        int minNum = Integer.MAX_VALUE;

        for (int num: nums) {
            sumNum += num;
            minNum = Math.min(minNum, num);
        }

        return sumNum - minNum * nums.length;
    }

}
