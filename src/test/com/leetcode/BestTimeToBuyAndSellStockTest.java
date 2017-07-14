package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/14.
 */
public class BestTimeToBuyAndSellStockTest {

    BestTimeToBuyAndSellStock test;

    @Before
    public void setUp() throws Exception {
        test = new BestTimeToBuyAndSellStock();
    }

    @Test
    public void testMaxProfit() throws Exception {
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        assertEquals(5, test.maxProfit(nums1));

        int[] nums2 = {7, 6, 4, 3, 1};
        assertEquals(0, test.maxProfit(nums2));
    }

}