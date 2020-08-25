package com.leetcode;

/**
 * [1544] Make The String Great
 * @link https://leetcode.com/problems/make-the-string-great/description/
 */
public class MakeStringGreat {

    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();

        for (char sChar: s.toCharArray()) {
            if (result.length() == 0) {
                result.append(sChar);
                continue;
            }
            if (result.charAt(result.length() - 1) != sChar &&
                    String.valueOf(result.charAt(result.length() - 1)).toLowerCase()
                            .equals(String.valueOf(sChar).toLowerCase())) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(sChar);
            }
        }

        return result.toString();
    }

}
