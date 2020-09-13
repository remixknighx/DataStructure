package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. Unique Binary Search Trees
 * @link https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTree {

    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        return numTrees(n, map);
    }

    private int numTrees(int n, Map<Integer, Integer> map){
        // check memory
        if(map.containsKey(n)) {
            return map.get(n);
        }
        // recursion
        int sum = 0;
        for(int i = 1;i <= n;i++) {
            sum += numTrees(i-1, map) * numTrees(n-i, map);
        }
        map.put(n, sum);
        return sum;
    }

}
