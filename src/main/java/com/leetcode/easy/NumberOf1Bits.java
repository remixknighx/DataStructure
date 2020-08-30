package com.leetcode.easy;

/**
 * @author wangjf
 * @date 2017 - 07 - 20 17:20
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        String binaryStr = Integer.toBinaryString(n);

        int count = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if(binaryStr.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
