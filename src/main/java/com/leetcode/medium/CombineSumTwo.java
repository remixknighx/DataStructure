package com.leetcode.medium;

import java.util.*;

/**
 * [40] Combination Sum II
 * @link https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombineSumTwo {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombineSumTwo().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        findSum(candidates, target, result, new LinkedList<>(), 0);
        return new ArrayList<>(result);
    }

    private void findSum(int[] candidates, int target, Set<List<Integer>> result, LinkedList<Integer> answer, int index) {

        if (target == 0) {
            result.add(new ArrayList<>(answer));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    answer.addLast(candidates[i]);
                    findSum(candidates, target - candidates[i], result, answer, i+1);
                    answer.removeLast();
                }
            }
        }
    }

}
