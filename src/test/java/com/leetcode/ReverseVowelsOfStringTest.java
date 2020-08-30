package com.leetcode;

import com.leetcode.easy.ReverseVowelsOfString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/29 0029.
 */
public class ReverseVowelsOfStringTest {

    ReverseVowelsOfString reverseVowelsOfString;

    @Before
    public void setUp() throws Exception {
        reverseVowelsOfString = new ReverseVowelsOfString();
    }

    @Test
    public void testReverseVowels() throws Exception {
        assertEquals("holle", reverseVowelsOfString.reverseVowels("hello"));
        assertEquals("leotcede", reverseVowelsOfString.reverseVowels("leetcode"));
        assertEquals("hvgtxw", reverseVowelsOfString.reverseVowels("hvgtxw"));
    }

}