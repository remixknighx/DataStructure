package com.leetcode.medium;

/**
 * 377. Combination Sum IV
 * @link https://leetcode.com/problems/combination-sum-iv/
 */
public class CombineSumFour {

    private int count = 0;

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(new CombineSumFour().combinationSum4(nums, 35));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

//    public int combinationSum4(int[] nums, int target) {
//
//        helper(nums, target);
//
//        return count;
//    }
//
//    private void helper(int[] nums, int target) {
//        if (target == 0) {
//            count++;
//            return;
//        }
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]) {
//                helper(nums, target - nums[i]);
//            }
//        }
//    }

}
