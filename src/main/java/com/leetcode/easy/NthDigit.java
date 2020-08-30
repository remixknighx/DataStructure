package com.leetcode.easy;

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

    // TODO �޷���⡣����
    public int findNthDigit(int n) {
        //С�����
        int digitType = 1;
        long digitNum = 9;

        //��λ���Ǽ�λ��
        while(n > digitNum * digitType) {
            n -= (int) digitNum*digitType ;
            digitType++;
            digitNum *= 10;
        }

        //��λ������Щ��λ������ĵڼ����ĵڼ�λ
        int indexInSubRange = (n - 1) / digitType;
        int indexInNum = (n - 1) % digitType;

        //��ԭ����
        int num = (int)Math.pow(10,digitType - 1) + indexInSubRange ;
        int result = Integer.parseInt((""+num).charAt(indexInNum)+"");

        return result;
    }
}
