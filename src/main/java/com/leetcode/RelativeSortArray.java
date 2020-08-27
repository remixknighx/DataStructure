package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [1122] Relative Sort Array
 *
 * @link https://leetcode.com/problems/relative-sort-array/description/
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        Map<Integer, Integer> arr1Map = new HashMap<>();
        for (int num : arr1) {
            arr1Map.put(num, arr1Map.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int num: arr2) {
            if (arr1Map.containsKey(num)) {
                int count = arr1Map.get(num);
                arr1Map.remove(num);
                for (int i = 0; i < count; i++) {
                    result[index++] = num;
                }
            }
        }

        List<Integer> keyList = arr1Map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer integer : keyList) {
            int count = arr1Map.get(integer);
            for (int i = 0; i < count; i++) {
                result[index++] = integer;
            }
        }

        return result;
    }

}
