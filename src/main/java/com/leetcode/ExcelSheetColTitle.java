package com.leetcode;

/**
 * 168. Excel Sheet Column Title
 * @link https://leetcode.com/problems/excel-sheet-column-title/#/description
 *
 * @author wangjf
 * @date 2017/7/18 0018.
 */
public class ExcelSheetColTitle {

    public static void main(String[] args) {
        ExcelSheetColTitle test = new ExcelSheetColTitle();
        System.out.println(test.convertToTitle(26 * 26 + 24));
    }

    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }

}
