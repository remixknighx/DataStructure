package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 350. Intersection Of Two Arrays
 * @Link https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * @author wangjf
 * @date 2017/8/1 0001.
 */
public class IntersectionOf2ArraysTwo {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        IntersectionOf2ArraysTwo intersecArrays = new IntersectionOf2ArraysTwo();
        int[] result = intersecArrays.intersect(nums1, nums2);

        for (int num: result) {
            System.out.println(num);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        List<Integer> intersectionList = new LinkedList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            intersectionList.add(i, nums1[i]);
        }

        List<Integer> resultList = new LinkedList<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (intersectionList.contains(nums2[j])) {
                intersectionList.remove((Integer) nums2[j]);
                resultList.add(nums2[j]);
            }
        }

        int[] result = new int[resultList.size()];
        int k = 0;
        for(int num: resultList) {
            result[k++] = num;
        }

        return result;
    }

}
