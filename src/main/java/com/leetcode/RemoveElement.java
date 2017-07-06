package com.leetcode;

/**
 * 27. Remove Element
 * @link https://leetcode.com/problems/remove-element/#/description
 *
 * @author wangjf
 * @date 2017/7/6.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 3};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
