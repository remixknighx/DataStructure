package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/28 0028.
 */
public class WordPatternTest {

    WordPattern wordPattern;

    @Before
    public void setUp() throws Exception {
        wordPattern = new WordPattern();
    }

    @Test
    public void testWordPattern() throws Exception {
        assertTrue(wordPattern.wordPattern("abba","dog cat cat dog"));
        assertFalse(wordPattern.wordPattern("abba","dog cat cat fish"));
        assertFalse(wordPattern.wordPattern("aaaa","dog cat cat dog"));
        assertFalse(wordPattern.wordPattern("abba","dog dog dog dog"));
    }

}