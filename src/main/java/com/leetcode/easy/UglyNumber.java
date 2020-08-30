package com.leetcode.easy;

/**
 * 263. Ugly Number
 * @link https://leetcode.com/problems/ugly-number/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 26 17:07
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(15));
    }

    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }

            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }

            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }

            return false;
        }

        return true;
    }
}
