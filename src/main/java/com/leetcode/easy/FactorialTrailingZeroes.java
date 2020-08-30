package com.leetcode.easy;

/**
 * 172. Factorial Trailing Zeroes
 * @link https://leetcode.com/problems/factorial-trailing-zeroes/#/description
 *
 * @author wangjf
 * @date 2017/7/18 0018.
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(144));
    }

    public int trailingZeroes(int n) {
        int sum = 0;

        while(n > 0){
            // 阶乘中有多少5，结果就有多少个0
            sum += n / 5;
            n /= 5;
        }

        return sum;
    }

}
