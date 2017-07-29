package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 349. Intersection of Two Arrays
 * @link https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @author wangjf
 * @date 2017 - 07 - 29 21:05
 */
public class IntersectionOf2Arrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
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

        int length = nums1.length > nums2.length? nums2.length: nums1.length;
        List<Integer> integerList = new LinkedList<Integer>();

        for (int i = 0; i < length; i++) {
            if (nums1[i] == nums2[i] && !integerList.contains(nums1)) {
                integerList.add(nums1[i]);
            }
        }

        if (integerList.size() == 0) {
            return null;
        }

        int[] result = new int[integerList.size()];
        for (int j = 0; j < integerList.size(); j++) {
            result[j] = integerList.get(j);
        }

        return result;
    }

}
