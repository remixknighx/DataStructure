package com.leetcode.easy;

import java.util.*;

/**
 * [1560] Most Visited Sector in  a Circular Track
 * @link https://leetcode.com/problems/most-visited-sector-in-a-circular-track/description/
 */
public class MostVisitedSector {

    public static void main(String[] args) {
        int n1 = 4;
        int[] rounds1 = new int[]{1,3,1,2};
        System.out.println(new MostVisitedSector().mostVisited(n1, rounds1));
        int n2 = 2;
        int[] rounds2 = new int[]{2,1,2,1,2,1,2,1,2};
        System.out.println(new MostVisitedSector().mostVisited(n2, rounds2));
        int n3 = 7;
        int[] rounds3 = new int[]{1,3,5,7};
        System.out.println(new MostVisitedSector().mostVisited(n3, rounds3));

    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        // end比start大
        for (int i = rounds[0]; i <= rounds[rounds.length - 1]; ++i) {
            res.add(i);
        }
        if (res.size() > 0) {
            return res;
        }
        // start比end大
        for (int i = 1; i <= rounds[rounds.length - 1]; ++i) {
            res.add(i);
        }
        for (int i = rounds[0]; i <= n; ++i) {
            res.add(i);
        }
        return res;
    }

}
