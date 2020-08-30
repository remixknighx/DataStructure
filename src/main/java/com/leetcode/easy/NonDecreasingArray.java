package com.leetcode.easy;

import java.util.Stack;

/**
 * 665. Non-decreasing Array
 * @link https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {

    public static void main(String[] args) {

    }

    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        // Index to mark where problem occurs
        int unwantedIndex = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (unwantedIndex != -1) {
                    //already one unwantedIndex existing
                    return false;
                }
                unwantedIndex = i - 1;
            }
        }
        // array is alreay non-decresing,no unwantedIndex found
        if (unwantedIndex == -1) {
            return true;
        }

        //if unwantedIndex is first integer in array replacing it with second index(i = 1)
        //if unwantedIndex is second last then replacing it with last value will make array non - decreasing
        if (unwantedIndex == 0 || unwantedIndex == (nums.length - 2)) {
            return true;
        }

        //check if the bump is only for one index and non decreasing behaviour resumes later
        if (nums[unwantedIndex - 1] <= nums[unwantedIndex + 1] || nums[unwantedIndex] <= nums[unwantedIndex + 2]) {
            return true;
        }

        return false;
    }

}
