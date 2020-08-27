package com.leetcode;

/**
 * [1128] Number of Equivalent Domino Pairs
 * @link https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
 */
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes.length <= 1) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i+1; j < dominoes.length; j++) {
                if (dominoes[i][0] + dominoes[i][1] != dominoes[j][0] + dominoes[j][1]) {
                    continue;
                }
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                        || (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])) {
                    count++;
                }
            }
        }

        return count;
    }

}
