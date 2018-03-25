package com.leetcode;

/**
 * 459. Repeated Substring Pattern
 * @link https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * @author wangjf
 * @date 2018/3/25 0025.
 */
public class RepeatedSubstring {

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int m = n / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

}
