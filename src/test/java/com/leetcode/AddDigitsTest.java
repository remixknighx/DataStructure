package com.leetcode;

import com.leetcode.easy.AddDigits;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/25 0025.
 */
public class AddDigitsTest {

    AddDigits addDigits;

    @Before
    public void setUp() throws Exception {
        addDigits = new AddDigits();
    }

    @Test
    public void testAddDigits() throws Exception {
        assertEquals(4, addDigits.addDigits(58));
        assertEquals(8, addDigits.addDigits(17));
        assertEquals(0, addDigits.addDigits(0));
        assertEquals(3, addDigits.addDigits(453));
    }

}