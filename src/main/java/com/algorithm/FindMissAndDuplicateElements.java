package com.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 寻找缺失和重复的元素
 */
public class FindMissAndDuplicateElements {

    public static void main(String[] args) {
        int[] nums = {0, 4, 1, 0, 2};
        System.out.println(findErrorNums(nums));
    }

    private static List<Integer> findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            // nums[index] 小于 0 则说明重复访问
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            // nums[i] 大于 0 则说明没有访问
            if (nums[i] > 0) {
                missing = i;
            }
        }

        return Arrays.asList(dup, missing);
    }

}
