package com.leetcode.easy;

/**
 * 231. Power of Two
 * @link https://leetcode.com/problems/power-of-two/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 24 21:42
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if(n == 0) {
            return false;
        }

        if (n % 2 == 0) {
            n = n / 2;
            return isPowerOfTwo(n);
        } else {
            return false;
        }
    }
}
