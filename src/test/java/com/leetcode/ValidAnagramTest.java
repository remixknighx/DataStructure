package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/25 0025.
 */
public class ValidAnagramTest {

    ValidAnagram validAnagram;

    @Before
    public void setUp() throws Exception {
        validAnagram = new ValidAnagram();
    }

    @Test
    public void testIsAnagram() throws Exception {
        assertTrue(validAnagram.isAnagram("anagram","nagaram"));
        assertTrue(validAnagram.isAnagram("abcdefg","dcbagfe"));
        assertFalse(validAnagram.isAnagram("abdcdefg","dcbagsfe"));
    }

}