package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [917] Reverse Only Letters
 * @link https://leetcode.com/problems/reverse-only-letters/description/
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] sChar = S.toCharArray();
        List<Character> sCharReverse = new ArrayList<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                sCharReverse.add(S.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                result.append(sCharReverse.remove(0));
            } else {
                result.append(sChar[i]);
            }
        }
        return result.toString();
    }
}
