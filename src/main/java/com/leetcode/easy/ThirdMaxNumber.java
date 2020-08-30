package com.leetcode.easy;


/**
 * 414. Third Maximum Number
 * @link https://leetcode.com/problems/third-maximum-number/description/
 *
 * @author wangjf
 * @date 2017/10/2 0002.
 */
public class ThirdMaxNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        ThirdMaxNumber thirdMaxNumber = new ThirdMaxNumber();
        System.out.println(thirdMaxNumber.thirdMax(nums));
    }

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num: nums) {
            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        return third == Long.MIN_VALUE? (int)first: (int)third;
    }

}
