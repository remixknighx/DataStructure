package com.leetcode;

/**
 * 400. Nth Digit
 * @link https://leetcode.com/problems/nth-digit/description/
 *
 * @author wangjf
 * @date 2017 - 08 - 22 17:42
 */
public class NthDigit {

    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();
        System.out.println(nthDigit.findNthDigit(11));
    }

    // TODO 无法理解。。。
    public int findNthDigit(int n) {
        //小心溢出
        int digitType = 1;
        long digitNum = 9;

        //定位到是几位数
        while(n > digitNum * digitType) {
            n -= (int) digitNum*digitType ;
            digitType++;
            digitNum *= 10;
        }

        //定位到是这些几位数里面的第几个的第几位
        int indexInSubRange = (n - 1) / digitType;
        int indexInNum = (n - 1) % digitType;

        //还原数字
        int num = (int)Math.pow(10,digitType - 1) + indexInSubRange ;
        int result = Integer.parseInt((""+num).charAt(indexInNum)+"");

        return result;
    }
}
