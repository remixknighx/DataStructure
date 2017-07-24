package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/24 0024.
 */
public class PowerOfTwoTest {

    PowerOfTwo powerOfTwo;

    @Before
    public void setUp() throws Exception {
        powerOfTwo = new PowerOfTwo();
    }

    @Test
    public void testIsPowerOfTwo() throws Exception {
        assertTrue(powerOfTwo.isPowerOfTwo(128));
        assertFalse(powerOfTwo.isPowerOfTwo(126));
    }

}