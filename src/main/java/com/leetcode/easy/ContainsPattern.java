package com.leetcode.easy;

/**
 * [1566] Detect Pattern of Length M Repeated K or More Times
 * @link https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/
 */
public class ContainsPattern {

    public static void main(String[] args) {
//        int[] num1 = {1,2,4,4,4,4};
//        System.out.println(containsPattern(num1, 1, 3));
//        int[] num2 = {1,2,1,2,1,1,1,3};
//        System.out.println(containsPattern(num2, 2, 2));
//        int[] num3 = {1,2,1,2,1,3};
//        System.out.println(containsPattern(num3, 2, 3));
//        int[] num4 = {1,2,3,1,2};
//        System.out.println(containsPattern(num4, 2, 2));
        int[] num5 = {1,2,1,3};
        System.out.println(containsPattern(num5, 2, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count >= (k - 1) * m) {
                return true;
            }
        }
        return false;
    }

}
