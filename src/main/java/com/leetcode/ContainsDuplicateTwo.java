package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate Two
 * @link https://leetcode.com/problems/contains-duplicate-ii/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 23 21:24
 */
public class ContainsDuplicateTwo {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                int differ = i - numMap.get(nums[i]);
                if (differ <= k) {
                    return true;
                } else {
                    numMap.put(nums[i], i);
                }
            } else {
                    numMap.put(nums[i], i);
            }
        }

        return false;
    }

}
