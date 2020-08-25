package com.leetcode;

/**
 * [1556] Thousand Separator
 * @link https://leetcode.com/problems/thousand-separator/description/
 */
public class ThousandSeparator {

    public static void main(String[] args) {
        System.out.println(new ThousandSeparator().thousandSeparator(51040));
    }

    public String thousandSeparator(int n) {
        String nStr = String.valueOf(n);
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = nStr.length()-1; i >= 0; i--) {
            count++;
            res.insert(0, nStr.charAt(i));
            if (count == 3 && i != 0) {
                res.insert(0, '.');
                count = 0;
            }
        }

        return res.toString();
    }

}
