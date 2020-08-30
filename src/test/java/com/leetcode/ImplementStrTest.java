package com.leetcode;

import com.leetcode.easy.ImplementStr;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/7.
 */
public class ImplementStrTest {

    ImplementStr implementStr;

    @Before
    public void setUp() throws Exception {
        implementStr = new ImplementStr();
    }

    @Test
    public void testStrStr() throws Exception {
        assertEquals(0, implementStr.strStr("as", "as"));
        assertEquals(3, implementStr.strStr("sdfasdwfas", "as"));
        assertEquals(0, implementStr.strStr("", ""));
        assertEquals(0, implementStr.strStr("sfs", ""));
    }

}