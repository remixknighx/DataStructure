package com.leetcode;

/**
 * 189. Rotate Array
 * @link https://leetcode.com/problems/rotate-array/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 20 15:50
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 1);
        for (int num: nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
        // TODO 没读懂题目的意思
        k = (nums.length + (k % nums.length)) % nums.length; // 保证k为正

        int tmp;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = 0, j = k - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = k, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
