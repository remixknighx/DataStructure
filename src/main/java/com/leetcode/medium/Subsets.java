package com.leetcode.medium;

import java.util.*;

/**
 * [78] Subsets
 * @link https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> single = new ArrayList<>();
        result.add(single);
        addToSubsets(result, nums, 0, single);
        return new ArrayList<>(result);
    }

    private void addToSubsets(List<List<Integer>> result, int[] nums, int startIdx, List<Integer> single) {
        for (int i = startIdx; i < nums.length; i++) {
            single.add(nums[i]);
            result.add(new ArrayList<>(single));
            addToSubsets(result, nums, i+1, single);
            single.remove(single.size()-1);
        }
    }

}
