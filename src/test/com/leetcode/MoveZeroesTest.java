package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/28 0028.
 */
public class MoveZeroesTest {

    MoveZeroes moveZeroes;

    @Before
    public void setUp() throws Exception {
        moveZeroes = new MoveZeroes();
    }

    @Test
    public void testMoveZeroes() throws Exception {
        int[] nums = {0, 1, 0, 13, 2};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 13, 2, 0, 0}, nums);
    }

}