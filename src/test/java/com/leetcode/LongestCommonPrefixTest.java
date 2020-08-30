package com.leetcode;

import com.leetcode.easy.LongestCommonPrefix;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/7.
 */
public class LongestCommonPrefixTest {

    LongestCommonPrefix longestCommonPrefix;

    @Before
    public void setUp() throws Exception {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    public void testLongestCommonPrefix() throws Exception {
        String[] strList = {"abcfsdf", "abcuihuio", "abcpuper"};
        assertEquals("abc", longestCommonPrefix.longestCommonPrefix(strList));

        String[] strList2 = {"abfdcfsdf", "cvabcuihuio", "wreabcpuper"};
        assertEquals("",longestCommonPrefix.longestCommonPrefix(strList2));
    }

}