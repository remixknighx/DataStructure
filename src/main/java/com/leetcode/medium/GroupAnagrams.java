package com.leetcode.medium;

import java.util.*;

/**
 * [49] Group Anagrams
 * @link https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(result);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str: strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

}
