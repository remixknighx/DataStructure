package com.leetcode;

/**
 * 405. Convert a Number to Hexadecimal
 * @link https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 *
 * @author wangjf
 * @date 2017/8/23 0023.
 */
public class ConvertNumToHex {

    public static void main(String[] args) {

    }

    /**
     * https://www.jiuzhang.com/solution/convert-a-number-to-hexadecimal/
     */
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        String ans = "";
        int len = 0;
        while(num != 0 && len < 8) {
            int bit = num & 15;
            if(bit < 10) {
                ans = (char)('0' + bit) + ans;
            }
            else {
                ans = (char)('a' + bit - 10) + ans;
            }
            num >>= 4;
            len++;
        }
        return ans;

    }

}
