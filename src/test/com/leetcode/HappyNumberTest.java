package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/20 0020.
 */
public class HappyNumberTest {

    HappyNumber happyNumber;

    @Before
    public void setUp() throws Exception {
        happyNumber = new HappyNumber();
    }

    @Test
    public void testIsHappy() throws Exception {

    }

    @Test
    public void testGetNextNum() throws Exception {
        assertEquals(82, happyNumber.getNextNum(19));
        assertEquals(68, happyNumber.getNextNum(82));
        assertEquals(100, happyNumber.getNextNum(68));
        assertEquals(1, happyNumber.getNextNum(100));

    }

}