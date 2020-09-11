package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * [46] Permutations
 * @link https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Permutations().permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doPermute(nums, result, new ArrayList<>());
        return result;
    }

    private void doPermute(int[] nums, List<List<Integer>> result, List<Integer> answer) {
        if (answer.size() == nums.length) {
            result.add(new ArrayList<>(answer));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!answer.contains(nums[i])) {
                    answer.add(nums[i]);
                    doPermute(nums, result, answer);
                    answer.remove(answer.size()-1);
                }
            }
        }
    }

}
