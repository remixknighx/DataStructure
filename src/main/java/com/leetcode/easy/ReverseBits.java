package com.leetcode.easy;

/**
 * 190. Reverse Bits
 * @link https://leetcode.com/problems/reverse-bits/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 20 16:46
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(324));
    }

    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

}
