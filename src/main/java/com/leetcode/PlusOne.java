package com.leetcode;

import java.util.ArrayList;

/**
 * 66. Plus One
 * @link https://leetcode.com/problems/plus-one/#/description
 *
 * @author wangjf
 * @date 2017/7/11.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

}
