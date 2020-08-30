package com.leetcode;

import com.leetcode.easy.PowerOfThree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/29 0029.
 */
public class PowerOfThreeTest {

    PowerOfThree powerOfThree;

    @Before
    public void setUp() throws Exception {
        powerOfThree = new PowerOfThree();
    }

    @Test
    public void testIsPowerOfThree() throws Exception {
        assertTrue(powerOfThree.isPowerOfThree(81));
        assertTrue(powerOfThree.isPowerOfThree(243));
        assertFalse(powerOfThree.isPowerOfThree(242));
    }

}