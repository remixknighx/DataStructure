package com.leetcode;

/**
 * 28. Implement strStr()
 * @link https://leetcode.com/problems/implement-strstr/#/description
 *
 * @author wangjf
 * @date 2017/7/6.
 */
public class ImplementStr {

    public static void main(String[] args) {
        String haystack = "fdsfabctyuiiw";
        System.out.println(haystack.substring(0, 3));
        String needle = "abc";
        System.out.println(new ImplementStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();

        for (int i = 0; i < haystack.length() - needleLength; i++) {
            haystack.substring()
        }

        return -1;
    }
}
