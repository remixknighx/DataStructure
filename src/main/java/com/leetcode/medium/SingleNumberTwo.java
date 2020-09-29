package com.leetcode.medium;

import java.util.Arrays;

/**
 * [137] Single Number II
 * @link https://leetcode.com/problems/single-number-ii/description/
 */
public class SingleNumberTwo {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(new SingleNumberTwo().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length;) {
            if (i >= nums.length - 1) {
                result = nums[i];
                break;
            }

            if (nums[i] == nums[i+1] && nums[i+2] == nums[i]) {
                i += 3;
            } else {
                result = nums[i];
                break;
            }
        }
        return result;
    }

}
