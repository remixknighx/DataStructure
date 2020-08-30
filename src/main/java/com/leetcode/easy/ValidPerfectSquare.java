package com.leetcode.easy;

/**
 * 367. Valid Perfect Square
 * @link https://leetcode.com/problems/valid-perfect-square/description/
 *
 * @author wangjf
 * @date 2017/8/1 0001.
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        int num = 9;
        ValidPerfectSquare validSquare = new ValidPerfectSquare();
        System.out.println(validSquare.isPerfectSquare(num));
    }

    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num / 2;

        if(num == 1) {
            return true;
        }

        long x = num;

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if(mid * mid == x)
                return true;
            else if(mid * mid < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

}
