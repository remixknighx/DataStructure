package com.leetcode;

import com.leetcode.easy.MaxDepthOfBinaryTree;
import com.leetcode.easy.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class MaxDepthOfBinaryTreeTest {

    MaxDepthOfBinaryTree treeDepth;

    @Before
    public void setUp() throws Exception {
        treeDepth = new MaxDepthOfBinaryTree();
    }

    @Test
    public void testMaxDepth() throws Exception {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(2);
        tree.left.left.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);

        assertEquals(4, treeDepth.maxDepth(tree));
    }

}