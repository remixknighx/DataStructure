package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class SingleNumberTest {

    SingleNumber singleNumber;

    @Before
    public void setUp() throws Exception {
        singleNumber = new SingleNumber();
    }

    @Test
    public void singleNumber() throws Exception {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8};
        assertEquals(6, singleNumber.singleNumber(nums));
        assertEquals(-1, singleNumber.singleNumber(null));
    }

}