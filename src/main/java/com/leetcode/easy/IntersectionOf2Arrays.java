package com.leetcode.easy;

import java.util.*;

/**
 * 349. Intersection of Two Arrays
 * @link https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @author wangjf
 * @date 2017 - 07 - 29 21:05
 */
public class IntersectionOf2Arrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 1};
        IntersectionOf2Arrays intersectionOf2Arrays = new IntersectionOf2Arrays();

        int[] intersection = intersectionOf2Arrays.intersection(nums1, nums2);
        for (int num: intersection) {
            System.out.println(num);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> intersectionSet = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            intersectionSet.add(nums1[i]);
        }

        Set<Integer> resultSet = new HashSet<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (intersectionSet.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }

        int[] result = new int[resultSet.size()];
        int k = 0;
        for(int num: resultSet) {
            result[k++] = num;
        }

        return result;
    }

}
