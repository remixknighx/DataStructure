package com.leetcode.easy;

/**
 * 58. Length of Last Word
 * @link https://leetcode.com/problems/length-of-last-word/#/description
 *
 * @author wangjf
 * @date 2017/7/10.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] sArray = s.split(" ");
        if (sArray.length == 0) {
            return 0;
        }

        return sArray[sArray.length-1].length();
    }
}
