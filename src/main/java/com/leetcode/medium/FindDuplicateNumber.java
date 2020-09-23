package com.leetcode.medium;

/**
 * [287] Find the Duplicate Number
 * @link https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(new FindDuplicateNumber().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        boolean[] numUsed = new boolean[nums.length];
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (numUsed[nums[i]]) {
                result = nums[i];
                break;
            } else {
                numUsed[nums[i]] = true;
            }
        }

        return result;
    }

}
