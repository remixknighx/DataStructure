package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [1047] Remove All Adjacent Duplicates In String
 * @link https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveDuplicateAdj {

    public String removeDuplicates(String S) {
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (result.size() == 0) {
                result.add(S.charAt(i));
            } else {
                if (result.get(result.size() - 1) == S.charAt(i)) {
                    result.remove(result.size() - 1);
                } else {
                    result.add(S.charAt(i));
                }
            }
        }

        StringBuilder strResult = new StringBuilder();
        for (Character character : result) {
            strResult.append(character);
        }
        return strResult.toString();
    }

}
