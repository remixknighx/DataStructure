package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * @link https://leetcode.com/problems/combination-sum-iii/
 */
public class CombineSumThree {

    public static void main(String[] args) {
        System.out.println(new CombineSumThree().combinationSum3(3, 7));
        System.out.println(new CombineSumThree().combinationSum3(3, 9));
        System.out.println(new CombineSumThree().combinationSum3(4, 1));
        System.out.println(new CombineSumThree().combinationSum3(3, 2));
        System.out.println(new CombineSumThree().combinationSum3(9, 45));

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, k, n, 1, new ArrayList<>());
        return result;
    }

    private void helper(List<List<Integer>> result, int k, int n, int startIdx, List<Integer> single) {
        if (n <= 0) {
            if (n == 0 && k == 0) {
                result.add(new ArrayList<>(single));
            }
            return;
        }

        for (int i = startIdx; i <= 9; i++) {
            single.add(i);
            helper(result, k-1, n-i, i+1, single);
            single.remove(single.size() - 1);
        }
    }

}
