package com.leetcode;

import com.leetcode.easy.ValidPalindrome;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class ValidPalindromeTest {

    ValidPalindrome validPalindrome;

    @Before
    public void setUp() throws Exception {
        validPalindrome = new ValidPalindrome();
    }

    @Test
    public void isPalindrome() throws Exception {
        assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindrome(null));
        assertFalse(validPalindrome.isPalindrome("race a car"));
        assertFalse(validPalindrome.isPalindrome("0P"));
    }

}