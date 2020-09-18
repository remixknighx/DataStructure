package com.leetcode.medium;

import java.util.*;

/**
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsTwo {

    public static void main(String[] args) {
       int[] nums = {1,2,2};
        System.out.println(new SubsetsTwo().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> single = new ArrayList<>();
        result.add(single);
        addToSubsets(result, nums, 0, single);
        return new ArrayList<>(result);
    }

    private void addToSubsets(Set<List<Integer>> result, int[] nums, int startIdx, List<Integer> single) {
        for (int i = startIdx; i < nums.length; i++) {
            single.add(nums[i]);
            result.add(new ArrayList<>(single));
            addToSubsets(result, nums, i+1, single);
            single.remove(single.size()-1);
        }
    }

}
