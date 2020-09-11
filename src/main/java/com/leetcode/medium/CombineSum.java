package com.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [39] Combination Sum
 *
 * @link https://leetcode.com/problems/combination-sum/description/
 */
public class CombineSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        List<List<Integer>> result = new CombineSum().combinationSum(candidates, 8);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, result, new LinkedList<>(), 0);
        return result;
    }

    private void findSum(int[] candidates, int target, List<List<Integer>> result, LinkedList<Integer> answer, int index) {

        if (target == 0) {
            result.add(new ArrayList<>(answer));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    answer.addLast(candidates[i]);
                    findSum(candidates, target - candidates[i], result, answer, i);
                    answer.removeLast();
                }
            }
        }
    }

}
