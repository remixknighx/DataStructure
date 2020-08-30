package com.leetcode.easy;

import java.util.HashSet;

/**
 * 202. Happy Number
 * @link https://leetcode.com/problems/happy-number/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 20 18:39
 */
public class HappyNumber {

    public static void main(String[] args) {
        int number = 19;
        System.out.println(new HappyNumber().isHappy(number));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> numberList = new HashSet<Integer>();
        while (n != 1) {
            n = getNextNum(n);
            if (numberList.contains(n)) {
                return false;
            }
            numberList.add(n);
        }
        return true;
    }

    public int getNextNum(int num){
        int result = 0;

        while (num / 10 != 0) {
            result += (num % 10) * (num % 10);
            num = num /10;
        }
        result += num * num;

        return result;
    }
}
