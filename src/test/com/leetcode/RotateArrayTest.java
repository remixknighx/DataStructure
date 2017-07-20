package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/20 0020.
 */
public class RotateArrayTest {

    RotateArray rotateArray;

    @Before
    public void setUp() throws Exception {
        rotateArray = new RotateArray();
    }

    @Test
    public void testRotate() throws Exception {
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

}