package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1331] Rank Transform of an Array
 *
 * @link https://leetcode.com/problems/rank-transform-of-an-array/description/
 */
public class RankTransformOfArray {

    public static void main(String[] args) {
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Integer, Integer> sortMap = new HashMap<>();
        int count = 0;
        for (int num: arr) {
            if (!sortMap.containsKey(num)) {
                sortMap.put(num, ++count);
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < copyArr.length; i++) {
            result[i] = sortMap.get(copyArr[i]);
        }
        return result;
    }

}
