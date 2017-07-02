package com.leetcode;

/**
 * 14. Longest Common Prefix
 * @link https://leetcode.com/problems/longest-common-prefix/#/description
 *
 * @author wangjf
 * @date 2017/7/2 0002.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strList = {"abcdefg", "abcdefghijk", "abcdefghijk", "abcdef"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strList));
    }

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        if (len == 0 ) {
            return "";
        }

        String shortestStr = strs[0];
        int minIndex = shortestStr.length();
        for(int i = 1; i < len; i ++) {
            if(minIndex > strs[i].length()) {
                minIndex = strs[i].length();
                shortestStr = strs[i];
            }
        }

        String result = "";
        boolean flag = true;
        for (int j = 0; j < minIndex && flag == true; j++) {
            char temp = shortestStr.charAt(j);
            for (int k = 0; k < len; k++) {
                if (strs[k].charAt(j) == temp){
                    if (k == len-1) {
                        result += temp;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
        }

        return result;
    }
}
