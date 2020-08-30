package com.leetcode;

import com.leetcode.easy.LengthOfLastWord;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/10.
 */
public class LengthOfLastWordTest {

    LengthOfLastWord lengthOfLastWord;

    @Before
    public void setUp() throws Exception {
        lengthOfLastWord = new LengthOfLastWord();
    }

    @Test
    public void testLengthOfLastWord() throws Exception {
        assertEquals(0, lengthOfLastWord.lengthOfLastWord("hello "));
        assertEquals(5, lengthOfLastWord.lengthOfLastWord("hello"));
        assertEquals(4, lengthOfLastWord.lengthOfLastWord("hello world test"));
        assertEquals(0, lengthOfLastWord.lengthOfLastWord("a "));
    }

}