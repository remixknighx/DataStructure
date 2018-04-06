package com.leetcode;

/**
 * 482. License Key Formatting
 * @link https://leetcode.com/problems/license-key-formatting/description/
 *
 * @author wangjf
 * @date 2018/4/6 0006.
 */
public class LicenseKeyFormat {

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//        sb.insert(0, "abc");
//        sb.insert(0,"efg");
//        System.out.println(sb.toString());

        String s = "2-4A0r7-4k";
        int k = 4;
        System.out.println(new LicenseKeyFormat().licenseKeyFormatting(s, k));
    }

    public String licenseKeyFormatting(String S, int K) {

        StringBuilder result = new StringBuilder();
        S = S.replaceAll("-", "").toUpperCase();

        int length = S.length() - 1;
        String temp = "";
        for (int i = length; i >= 0; i--) {
            temp = S.charAt(i) + temp;
            if(temp.length() == K){
                result.insert(0, "-" + temp);
                temp = "";
            }
        }
        if(temp.length() != 0){
            result.insert(0, "-" + temp);
        }

        if(result.toString().startsWith("-")){
            result.deleteCharAt(0);
        }

        return result.toString().toUpperCase();
    }

}
