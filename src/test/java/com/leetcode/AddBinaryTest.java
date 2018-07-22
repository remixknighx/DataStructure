package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/11.
 */
public class AddBinaryTest {

    AddBinary addBinary;

    @Before
    public void setUp() throws Exception {
        addBinary = new AddBinary();
    }

    @Test
    public void testAddBinary() throws Exception {
        assertEquals("1", addBinary.addBinary("1", "0"));
        assertEquals("0", addBinary.addBinary("0", "0"));
        assertEquals("10", addBinary.addBinary("1", "1"));
        assertEquals("100", addBinary.addBinary("11", "1"));
        assertEquals("1010", addBinary.addBinary("111", "11"));
        assertEquals("11001", addBinary.addBinary("1110", "1011"));
    }

    @Test
    public void testConvertStrToInt(){
        assertArrayEquals(new int[]{1, 1, 1}, addBinary.convertStrToInt("111"));
        assertArrayEquals(new int[]{1, 0, 1}, addBinary.convertStrToInt("101"));
        assertArrayEquals(new int[]{1, 1, 0, 1}, addBinary.convertStrToInt("1011"));
    }

}