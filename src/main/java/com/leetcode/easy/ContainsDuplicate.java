package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * @link https://leetcode.com/problems/contains-duplicate/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 23 21:11
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return false;
        }

        Set<Integer> numSet = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }

        return false;
    }

}
