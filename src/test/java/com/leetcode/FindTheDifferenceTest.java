package com.leetcode;

import com.leetcode.easy.FindTheDifference;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/8/22 0022.
 */
public class FindTheDifferenceTest {

    FindTheDifference fid;

    @Before
    public void setUp() throws Exception {
        fid = new FindTheDifference();
    }

    @Test
    public void testFindTheDifference() throws Exception {
        String s1 = "abcdef";
        String t1 = "abcdefg";
        assertEquals('g', fid.findTheDifference(s1, t1));

        String s2 = "fsadfasd";
        String t2 = "fseadfasd";
        assertEquals('e', fid.findTheDifference(s2, t2));
    }

}