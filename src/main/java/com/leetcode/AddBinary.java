package com.leetcode;

/**
 * 67. Add Binary
 * @link https://leetcode.com/problems/add-binary/#/description
 *
 * @author wangjf
 * @date 2017/7/11.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int[] aInt = convertStrToInt(a);
        int[] bInt = convertStrToInt(b);
        StringBuilder result = new StringBuilder();

        int shortIntLength = (aInt.length > bInt.length)? bInt.length: aInt.length;
        int[] longInt = (aInt.length > bInt.length)? aInt: bInt;
        int carry = 0;
        for (int i = 0; i < shortIntLength; i++) {
            carry = aInt[i] + bInt[i] + carry;
            result.append(carry % 2);
            carry = carry / 2;
        }

        for (int j = shortIntLength; j < longInt.length; j++) {
            carry = longInt[j] + carry;
            result.append(carry % 2);
            carry = carry/2;
        }

        if(carry == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    /**
     * 把String类型的二进制转化为int[]类型
     *
     * @param str String类型的二进制
     * @return int[]类型的二进制
     */
    public int[] convertStrToInt(String str) {
        int[] res = new int[str.length()];

        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--, j++) {
            switch (str.charAt(i)) {
                case '1':
                    res[j] = 1;
                    break;
                case '0':
                    res[j] = 0;
                    break;
            }
        }

        return res;
    }

}
