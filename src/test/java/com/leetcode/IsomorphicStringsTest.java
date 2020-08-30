package com.leetcode;

import com.leetcode.easy.IsomorphicStrings;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/21 0021.
 */
public class IsomorphicStringsTest {

    IsomorphicStrings test;

    @Before
    public void setUp() throws Exception {
        test = new IsomorphicStrings();
    }

    @Test
    public void testIsIsomorphic() throws Exception {
        assertTrue(test.isIsomorphic("ass", "bff"));
        assertFalse(test.isIsomorphic("ads", "bff"));
        assertTrue(test.isIsomorphic("add4", "bff8"));
    }

}