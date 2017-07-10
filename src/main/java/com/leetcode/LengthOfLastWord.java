package com.leetcode;

/**
 * 58. Length of Last Word
 * @link https://leetcode.com/problems/length-of-last-word/#/description
 *
 * @author wangjf
 * @date 2017/7/10.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        new LengthOfLastWord().lengthOfLastWord("a ");
    }

    public int lengthOfLastWord(String s) {
        if (s.lastIndexOf(' ') == -1) {
            return s.length();
        }

        if (s.lastIndexOf(' ') + 1 == s.length()) {
            return 0;
        } else {
            return s.substring(s.lastIndexOf(' ')+1).length();
        }
    }
}
