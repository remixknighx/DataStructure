package com.leetcode;

import com.leetcode.easy.LongestPalindrome;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/8/23 0023.
 */
public class LongestPalindromeTest {

    LongestPalindrome longestPalindrome;

    @Before
    public void setUp() {
        longestPalindrome = new LongestPalindrome();
    }

    @Test
    public void longestPalindrome() {
        String s1 = "";
        assertEquals(0, longestPalindrome.longestPalindrome(s1));

        String s2 = "aaabbccd";
        assertEquals(7, longestPalindrome.longestPalindrome(s2));
    }

}
