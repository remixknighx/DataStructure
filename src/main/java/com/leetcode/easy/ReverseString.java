package com.leetcode.easy;

/**
 * 344. Reverse String
 * @link https://leetcode.com/problems/reverse-string/description/
 *
 * @author wangjf
 * @date 2017 - 07 - 29 20:36
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "helloworld";
        ReverseString reverseStr = new ReverseString();
        System.out.println(reverseStr.reverseString(s));
    }

    public String reverseString(String s) {
        char[] sChar = new char[s.length()];

        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            sChar[count++] = s.charAt(i);
        }

        return new String(sChar);
    }
}
