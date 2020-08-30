package com.leetcode;

import com.leetcode.easy.PathSum;
import com.leetcode.easy.TreeNode;
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
        /**
         * ���νṹ
         *           5
         *          / \
         *         4   8
         *        /   / \
         *      11   13  4
         *     / \        \
         *    7   2        1
         */
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

        /**
         * ���νṹ
         *        1
         *       /
         *      2
         */
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        assertFalse(pathSum.hasPathSum(tree2, 1));

        TreeNode tree3 = new TreeNode(1);
        assertFalse(pathSum.hasPathSum(tree3, 0));
    }

}