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
        if(nums.length == 0 || nums.length < k) {
            return;
        }

        int[] temp = new int[k];
        int length = nums.length;
        int[] newNums = new int[length];

        for (int i = 0; i < k; i++) {
            temp[i] = nums[length - k + i];
        }

        for (int i = 0; i < k; i++) {
            newNums[i] = temp[i];
        }

        for (int i = 0; i < length - k; i++) {
            newNums[i+k] = nums[i];
        }
    }
}
