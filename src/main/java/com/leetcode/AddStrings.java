package com.leetcode;

/**
 * 415. Add Strings
 * @link https://leetcode.com/problems/add-strings/description/
 *
 * @author wangjf
 * @date 2017/9/10 0010.
 */
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "234";
        String num2 = "3424";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                carry += num1.charAt(i--) - '0';
            if (j >= 0)
                carry += num2.charAt(j--) - '0';
            res = Integer.toString(carry % 10) + res;
            carry /= 10;
        }

        return carry != 0 ? "1" + res : res;
    }

}
