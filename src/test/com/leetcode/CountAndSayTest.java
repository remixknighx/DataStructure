package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/10.
 */
public class CountAndSayTest {

    private CountAndSay countAndSay;

    @Before
    public void setUp() throws Exception {
        countAndSay = new CountAndSay();
    }

    @Test
    public void testCountAndSay() throws Exception {
        assertEquals("1", countAndSay.countAndSay(1));
        assertEquals("11", countAndSay.countAndSay(2));
        assertEquals("21", countAndSay.countAndSay(3));
        assertEquals("1211", countAndSay.countAndSay(4));
        assertEquals("111221", countAndSay.countAndSay(5));
        assertEquals("312211", countAndSay.countAndSay(6));
        assertEquals("13112221", countAndSay.countAndSay(7));
        assertEquals("1113213211", countAndSay.countAndSay(8));
    }

}