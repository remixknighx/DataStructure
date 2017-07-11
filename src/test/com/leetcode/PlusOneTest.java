package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/11.
 */
public class PlusOneTest {

    PlusOne plusOne;

    @Before
    public void setUp() throws Exception {
        plusOne = new PlusOne();
    }

    @Test
    public void testPlusOne() throws Exception {
        assertArrayEquals(new int[]{1}, plusOne.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{2, 3, 6, 0}, plusOne.plusOne(new int[]{2, 3, 5, 9}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, plusOne.plusOne(new int[]{9, 9, 9}));
        assertArrayEquals(new int[]{2, 9, 4, 0}, plusOne.plusOne(new int[]{2, 9, 3, 9}));
    }

}