package com.leetcode.easy;

/**
 * 13. Roman to Integer
 * @link https://leetcode.com/problems/roman-to-integer/#/description
 * Refer to @link http://blog.csdn.net/ljiabin/article/details/39968583
 *
 * @author wangjf
 * @date 2017/6/25 0025.
 */
public class RomainToInteger {

    public static void main(String[] args) {
        String s = "MMMCMLXXVII";
        System.out.println(new RomainToInteger().romanToInt(s));
    }

    public int romanToInt(String s) {
        char[] sChar = s.toCharArray();

        int ret = toNumber(sChar[0]);
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(sChar[i - 1]) < toNumber(sChar[i])) {
                ret = ret + toNumber(sChar[i]) - 2 * toNumber(sChar[i - 1]);
            } else {
                ret += toNumber(sChar[i]);
            }
        }
        return ret;
    }

    int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

}
