package com.leetcode.easy;

/**
 * [1299] Replace Elements with Greatest Element on Right Side
 * @link https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 */
public class ReplaceElements {

    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] result = new int[arr.length];
        int maxRight = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                result[i] = -1;
                maxRight = arr[i];
                continue;
            } else {
                result[i] = maxRight;
            }

            if (maxRight < arr[i]) {
                maxRight = arr[i];
            }
        }
        return result;
    }

}
