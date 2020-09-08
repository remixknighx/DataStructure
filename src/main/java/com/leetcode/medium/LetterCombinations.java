package com.leetcode.medium;

import java.util.*;

/**
 * [17] Letter Combinations of a Phone Number
 * @link https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.trim().length() == 0) {
            return new ArrayList<>(0);
        }

        Map<Character, List<String>> digitMap = new HashMap<>();
        digitMap.put('2', Arrays.asList("a", "b", "c"));
        digitMap.put('3', Arrays.asList("d", "e", "f"));
        digitMap.put('4', Arrays.asList("g", "h", "i"));
        digitMap.put('5', Arrays.asList("j", "k", "l"));
        digitMap.put('6', Arrays.asList("m", "n", "o"));
        digitMap.put('7', Arrays.asList("p", "q", "r", "s"));
        digitMap.put('8', Arrays.asList("t", "u", "v"));
        digitMap.put('9', Arrays.asList("w", "x", "y", "z"));

        if (digits.length() == 1) {
            return digitMap.get(digits.charAt(0));
        }

        List<String> result = new ArrayList<>();
        result.addAll(digitMap.get(digits.charAt(0)));
        for (int i = 1; i < digits.length(); i++) {
            List<String> tempResult = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < digitMap.get(digits.charAt(i)).size(); k++) {
                    tempResult.add(result.get(j) + digitMap.get(digits.charAt(i)).get(k));
                }
            }
            result = tempResult;
        }

        return result;
    }

}
