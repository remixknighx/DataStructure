package com.leetcode;

import com.leetcode.easy.ValidPerfectSquare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/8/1 0001.
 */
public class ValidPerfectSquareTest {

    ValidPerfectSquare validPerfectSquare;

    @Before
    public void setUp() throws Exception {
        validPerfectSquare = new ValidPerfectSquare();
    }

    @Test
    public void isPerfectSquare() throws Exception {
        assertTrue(validPerfectSquare.isPerfectSquare(64));
        assertFalse(validPerfectSquare.isPerfectSquare(78));
    }

}