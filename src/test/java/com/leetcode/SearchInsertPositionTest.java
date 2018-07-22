package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/10.
 */
public class SearchInsertPositionTest {

    SearchInsertPosition searchInsertPosition;

   int[] nums;

    @Before
    public void setUp() {
        searchInsertPosition = new SearchInsertPosition();
        nums = new int[]{1, 3, 5, 7, 9};
    }

    @Test
    public void testSearchInsert() throws Exception {
        assertEquals(1, searchInsertPosition.searchInsert(nums, 2));
        assertEquals(1, searchInsertPosition.searchInsert(nums, 3));
        assertEquals(0, searchInsertPosition.searchInsert(nums, 0));
        assertEquals(5, searchInsertPosition.searchInsert(nums, 10));
    }

}