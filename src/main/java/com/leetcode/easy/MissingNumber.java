package com.leetcode.easy;

/**
 * 268. Missing Number
 * @link https://leetcode.com/problems/missing-number/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 26 20:28
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        MissingNumber missingNum = new MissingNumber();
        System.out.println(missingNum.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length, i = 0;

        while (i<n) {
            while (nums[i] != i && nums[i] < n) {
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
            ++i;
        }

        for (i=0; i<n; ++i) {
            if (nums[i]!=i) {
                return i;
            }
        }

        return n;

    }
}
