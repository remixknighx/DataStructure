package com.leetcode;

/**
 * @author wangjf
 * @date 2017 - 07 - 29 20:31
 */
public class PowerOfFour {

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(64));
        System.out.println(powerOfFour.isPowerOfFour(36));
    }

    public boolean isPowerOfFour(int num) {
        if(num == 0) {
            return false;
        }

        if(num == 1) {
            return true;
        }

        while (num % 4 == 0) {
            num = num / 4;
            if (num == 1) {
                return true;
            }
        }

        return false;
    }

}
