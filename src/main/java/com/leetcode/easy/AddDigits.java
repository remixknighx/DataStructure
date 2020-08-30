package com.leetcode.easy;

/**
 * 258. Add Digits
 * @link https://leetcode.com/problems/add-digits/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 25 22:15
 */
public class AddDigits {

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(58));
    }

    public int addDigits(int num) {
        while (num / 10 != 0) {
            int temp = num;
            num = 0;
            while (temp / 10 != 0) {
                num += temp % 10;
                temp = temp / 10;
            }
            num += temp;
        }

        return num;
    }

}
