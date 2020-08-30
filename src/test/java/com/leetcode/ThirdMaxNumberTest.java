package com.leetcode;

import com.leetcode.easy.ThirdMaxNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/10/2 0002.
 */
public class ThirdMaxNumberTest {

    ThirdMaxNumber thirdMaxNumber;

    @Before
    public void setUp() throws Exception {
        thirdMaxNumber = new ThirdMaxNumber();
    }

    @Test
    public void testThirdMax() throws Exception {
        int[] nums1 = {4, 3, 5, 2, 5};
        assertEquals(3, thirdMaxNumber.thirdMax(nums1));

        int[] nums2 = {3};
        assertEquals(3, thirdMaxNumber.thirdMax(nums2));

        int[] nums3 = {1, 2};
        assertEquals(2, thirdMaxNumber.thirdMax(nums3));

        int[] nums4 = {1, 2, 3, 4, 5};
        assertEquals(3, thirdMaxNumber.thirdMax(nums4));

        int[] nums5 = {1, 2, -2147483648};
        assertEquals(-2147483648, thirdMaxNumber.thirdMax(nums5));
    }

}