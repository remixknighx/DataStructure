package com.leetcode;

/**
 * [1332] Remove Palindromic Subsequences
 *
 * @link https://leetcode.com/problems/remove-palindromic-subsequences/description/
 */
public class RemovePalindromeSub {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }

        return 2;
    }

}
