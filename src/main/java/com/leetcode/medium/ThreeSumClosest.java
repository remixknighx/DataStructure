package com.leetcode.medium;

import java.util.Arrays;

/**
 * [16] 3Sum Closest
 * @link https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        int target = -100;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;
        int minDistance = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int temp = target - nums[i] - nums[j] - nums[k];
                if (temp < 0) {
                    k--;
                } else if (temp > 0) {
                    j++;
                } else {
                    return target;
                }
                if (Math.abs(temp) < minDistance) {
                    minDistance = Math.abs(temp);
                    result = target - temp;
                }
            }
        }

        return result;
    }

}
