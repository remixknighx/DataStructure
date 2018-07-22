package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/12.
 */
public class MergeSortedArrayTest {

    MergeSortedArray mergeSortedArray;

    @Before
    public void setUp() throws Exception {
        mergeSortedArray = new MergeSortedArray();
    }

    @Test
    public void testMerge() throws Exception {
        int[] nums1 = {1, 3};
        int[] nums2 = {5, 7};
        assertArrayEquals(new int[]{1, 3, 5, 7}, mergeSortedArray.merge(nums1, nums1.length, nums2, nums2.length));

        int[] nums3 = {1, 2, 5};
        int[] nums4 = {3, 4};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, mergeSortedArray.merge(nums3, nums3.length, nums4, nums4.length));

        int[] nums5 = {1, 2, 3};
        int[] nums6 = {2, 4};
        assertArrayEquals(new int[]{1, 2, 2, 3, 4}, mergeSortedArray.merge(nums5, nums5.length, nums6, nums6.length));
    }

}