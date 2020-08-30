package com.leetcode.easy;

/**
 * 9. Palindrome Number
 * @link https://leetcode.com/problems/palindrome-number/#/description
 *
 * @author wangjf
 * @date 2017/6/24 0024.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int number = 7;

        System.out.println(new PalindromeNumber().isPalindrome(number));
    }

    public boolean isPalindrome(int x) {
        // 负数不能为回文数
        if (x < 0) {
            return false;
        }

        // 个位数为回文数
        if(x >= 0 && x < 10){
            return true;
        }

        int temp = x;
        int div = 1;
        int length = 1;
        while ((temp = temp / 10) >= 10) {
            div *= 10;
            length++;
        }
        div *= 10;
        length++;

        int front;
        int end;
        for (int i = 0; i < length / 2; i++) {
            end = x % (int)Math.pow(10, i + 1);
            front = x / div;
            if (i != 0) {
                end = end / (int)Math.pow(10, i);
                front = front % 10;
            }

            if (front != end) {
                return false;
            }

            div = div / 10;
        }

        return true;
    }

}
