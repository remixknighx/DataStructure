package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 88. Merge Sorted Array
 * @link https://leetcode.com/problems/merge-sorted-array/#/description
 *
 * @author wangjf
 * @date 2017/7/12.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = {2,5,6};
        new MergeSortedArray().merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = 0;

        for (int i = 0; i < nums2.length; i++) {

            nums1[index + m] = nums2[i];

            index++;

        }

        Arrays.sort(nums1);
    }

}
