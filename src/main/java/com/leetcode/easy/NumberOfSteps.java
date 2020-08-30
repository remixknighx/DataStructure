package com.leetcode.easy;

/**
 * [1342] Number of Steps to Reduce a Number to Zero
 *
 * @link https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */
public class NumberOfSteps {

    public int numberOfSteps (int num) {
        int count = 0;
        while (true) {
            if (num == 0) {
                break;
            }

            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }

}
