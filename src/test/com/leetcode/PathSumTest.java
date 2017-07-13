package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class PathSumTest {

    PathSum pathSum;

    @Before
    public void setUp() throws Exception {
        pathSum = new PathSum();
    }

    @Test
    public void testHasPathSum() throws Exception {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(1);

        assertTrue(pathSum.hasPathSum(tree, 22));
        assertTrue(pathSum.hasPathSum(tree, 26));
        assertFalse(pathSum.hasPathSum(tree, 38));
    }

}