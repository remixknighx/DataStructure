package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class TwoSum2Test {

    TwoSum2 twoSum;
    int[] nums;
    @Before
    public void setUp() throws Exception {
        twoSum = new TwoSum2();
        nums = new int[]{2, 7, 9, 11, 15, 17};
    }

    @Test
    public void twoSum() throws Exception {
        assertArrayEquals(new int[]{1, 4}, twoSum.twoSum(nums, 13));
        assertArrayEquals(new int[]{3, 4}, twoSum.twoSum(nums, 20));
        assertArrayEquals(new int[]{2, 5}, twoSum.twoSum(nums, 22));
    }

}