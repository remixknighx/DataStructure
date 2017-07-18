package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/18 0018.
 */
public class ExcelSheetColTitleTest {

    ExcelSheetColTitle test;

    @Before
    public void setUp() throws Exception {
        test = new ExcelSheetColTitle();
    }

    @Test
    public void convertToTitle() throws Exception {
        assertEquals("E",test.convertToTitle(5));
        assertEquals("AB",test.convertToTitle(28));
        assertEquals("YB",test.convertToTitle(652));
        assertEquals("AAA",test.convertToTitle(677));
    }

}