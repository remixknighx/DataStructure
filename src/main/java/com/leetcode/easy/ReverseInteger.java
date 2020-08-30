package com.leetcode.easy;

/**
 * 7. Reverse Integer
 * @link https://leetcode.com/problems/reverse-integer/#/description
 *
 * @author wangjf
 * @date 2017/6/24 0024.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int num = Integer.MIN_VALUE + 1;

        System.out.println(new ReverseInteger().reverse(num));
    }

    public int reverse(int x) {
        // 需要考虑极值情况
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        StringBuilder number = new StringBuilder();

        int absNum = Math.abs(x);
        while (absNum >= 10) {
            number.append(absNum % 10);
            absNum = absNum / 10;
        }
        number.append(absNum);

        int result = 0;
        try {
            if (x > 0) {
                result = Integer.valueOf(number.toString());
            } else if (x < 0) {
                result = -Integer.valueOf(number.toString());
            } else {
                result = 0;
            }
        } catch (NumberFormatException e) {
            // 若输入数字为32位，输出数字大于32位，则抛出异常
            // 并将结果设为0返回
            result = 0;
        }

        return result;
    }
}
