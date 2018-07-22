package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/26 0026.
 */
public class UglyNumberTest {

    UglyNumber uglyNumber;

    @Before
    public void setUp() throws Exception {
        uglyNumber = new UglyNumber();
    }

    @Test
    public void testIsUgly() throws Exception {
        assertTrue(uglyNumber.isUgly(75));
        assertTrue(uglyNumber.isUgly(100));
        assertFalse(uglyNumber.isUgly(102));
    }

}