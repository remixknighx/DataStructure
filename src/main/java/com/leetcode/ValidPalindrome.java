package com.leetcode;

/**
 * 125. Valid Palindrome
 * @link https://leetcode.com/problems/valid-palindrome/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        StringBuffer stringBuffer = new StringBuffer();

        int temp;
        for (int i = 0; i < s.length(); i++) {
            temp = Integer.valueOf(s.charAt(i));
            if ((temp >= 65 && temp <= 90) || (temp >= 97 && temp <= 122) || (temp >= 48 && temp <= 57)) {
                stringBuffer.append(s.charAt(i));
            }
        }

        return stringBuffer.toString().equalsIgnoreCase(stringBuffer.reverse().toString());
    }
}
