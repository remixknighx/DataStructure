package com.leetcode.medium;

/**
 * [5] Longest Palindromic Substring
 * @link https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int resLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    result = s.substring(left, right+1);
                    resLength = right - left + 1;
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    result = s.substring(left, right+1);
                    resLength = right - left + 1;
                }
                left--;
                right++;
            }

        }

        return result;
    }

}
