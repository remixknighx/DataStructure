package com.leetcode;

/**
 * 28. Implement strStr()
 *
 * @author wangjf
 * @link https://leetcode.com/problems/implement-strstr/#/description
 * @date 2017/7/6.
 */
public class ImplementStr {

    public static void main(String[] args) {
        String haystack = "mississippi" ;
        String needle = "pi";
        System.out.println(new ImplementStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();

        if (needleLength == 0) {
            return 0;
        }

        if (haystack.length() == needleLength && haystack.equals(needle)) {
            return 0;
        } else {
            for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
                if (haystack.substring(i, i + needleLength).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
