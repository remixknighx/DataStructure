package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/23 0023.
 */
public class ContainsDuplicateTest {

    ContainsDuplicate containsDuplicate;

    @Before
    public void setUp() throws Exception {
        containsDuplicate = new ContainsDuplicate();
    }

    @Test
    public void testContainsDuplicate() throws Exception {
        assertTrue(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5, 1}));
        assertFalse(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6}));
        assertFalse(containsDuplicate.containsDuplicate(new int[]{}));
    }

}