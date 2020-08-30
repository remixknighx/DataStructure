package com.leetcode.easy;

/**
 * 326. Power of Three
 * @link https://leetcode.com/problems/power-of-three/description/
 *
 * @author wangjf
 * @date 2017 - 07 - 29 20:22
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if(n == 0) {
            return false;
        }

        if(n == 1) {
            return true;
        }

        while (n % 3 == 0) {
            n = n / 3;
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

}
