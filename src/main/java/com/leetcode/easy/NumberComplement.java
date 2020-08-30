package com.leetcode.easy;

/**
 * 476. Number Complement
 * @link https://leetcode.com/problems/number-complement/description/
 *
 * @author wangjf
 * @date 2018/4/6 0006.
 */
public class NumberComplement {

    public static void main(String[] args) {
        int num = 1;
        // 100 -> 011 3
        System.out.println(new NumberComplement().findComplement(num));
    }

    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '0'? 1: 0);
        }

        return Integer.parseInt(sb.toString(), 2);
    }

}
