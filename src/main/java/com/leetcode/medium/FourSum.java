package com.leetcode.medium;

import java.util.*;

/**
 * [18] 4Sum
 * @link https://leetcode.com/problems/4sum/description/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>(0);
        }

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int k = j+1;
                int l = nums.length-1;
                while (k < l) {
                    int temp = nums[i] + nums[j] + nums[k] + nums[l];
                    if (temp > target) {
                        l--;
                    } else if (temp < target) {
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l--;
                        k++;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

}
