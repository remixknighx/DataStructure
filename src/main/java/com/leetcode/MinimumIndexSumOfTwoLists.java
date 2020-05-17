package com.leetcode;

import java.util.*;

/**
 * 599. Minimum Index Sum of Two Lists
 * @link https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.asList(new MinimumIndexSumOfTwoLists.Solution().findRestaurant(list1, list2)));
    }

    private static class Solution {

        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> andyMap = new HashMap<>();
            int count = 0;
            for (String str1: list1) {
                andyMap.put(str1, ++count);
            }

            Map<Integer, List<String>> resultMap = new HashMap<>();
            int minIndex = Integer.MAX_VALUE;
            count = 0;
            for (String str2: list2) {
                count++;
                if (andyMap.containsKey(str2)) {
                    int totalCount = count + andyMap.get(str2);
                    if (totalCount < minIndex) {
                        minIndex = totalCount;
                    }
                    List<String> curRestaurant = resultMap.get(totalCount);
                    if (curRestaurant == null || curRestaurant.size() == 0) {
                        curRestaurant = new ArrayList<>();
                    }
                    curRestaurant.add(str2);
                    resultMap.put(totalCount, curRestaurant);
                }
            }

            String[] result = new String[resultMap.get(minIndex).size()];
            resultMap.get(minIndex).toArray(result);
            return result;
        }
    }

}

