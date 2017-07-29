package com.leetcode;

/**
 * 283. Move Zeroes
 * @Link https://leetcode.com/problems/move-zeroes/tabs/description
 *
 * @author wangjf
 * @date 2017 - 07 - 28 23:10
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);

        for (int num: nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for (int j = count; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
