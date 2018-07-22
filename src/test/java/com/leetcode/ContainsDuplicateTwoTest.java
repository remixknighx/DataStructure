package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/23 0023.
 */
public class ContainsDuplicateTwoTest {

    ContainsDuplicateTwo containsDuplicateTwo;

    @Before
    public void setUp() throws Exception {
        containsDuplicateTwo = new ContainsDuplicateTwo();
    }

    @Test
    public void testContainsNearbyDuplicate() throws Exception {
        assertTrue(containsDuplicateTwo.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 4, 5, 6}, 3));
        assertFalse(containsDuplicateTwo.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 4, 5, 6}, 2));
    }

}