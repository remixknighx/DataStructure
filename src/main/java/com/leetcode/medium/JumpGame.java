package com.leetcode.medium;

/**
 * [55] Jump Game
 * @link https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};
        System.out.println(new JumpGame().canJump(nums));
//        int[] nums2 = {3,2,1,0,4};
//        System.out.println(new JumpGame().canJump(nums2));
//        int[] nums3 = {1, 2, 0, 1};
//        System.out.println(new JumpGame().canJump(nums3));
//        int[] nums4 = {2, 0, 0};
//        System.out.println(new JumpGame().canJump(nums4));
//        int[] nums5 = {1,1,2,2,0,1,1};
//        System.out.println(new JumpGame().canJump(nums5));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

}
