package com.leetcode.easy;

/**
 * 167. Two Sum II - Input array is sorted
 * @link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
       int[] indixes = new int[2];

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                indixes[0] = left + 1;
                indixes[1] = right + 1;
                return indixes;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
