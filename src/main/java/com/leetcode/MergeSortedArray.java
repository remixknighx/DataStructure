package com.leetcode;

/**
 * 88. Merge Sorted Array
 * @link https://leetcode.com/problems/merge-sorted-array/#/description
 *
 * @author wangjf
 * @date 2017/7/12.
 */
public class MergeSortedArray {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = nums1;
        nums1 = new int[m + n];
        int j = 0, k = 0;

        for (int i = 0; i < m + n; i++) {
            if (j != m && k != n) {
                if (temp[j] < nums2[k]) {
                    nums1[i] = temp[j++];
                } else {
                    nums1[i] = nums2[k++];
                }
            } else if (j == m) {
                nums1[i] = nums2[k++];
            } else {
                nums1[i] = temp[j++];
            }
        }
        return nums1;
    }

}
