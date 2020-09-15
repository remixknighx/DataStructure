package com.leetcode;

import com.leetcode.easy.MinDepthOfBinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class MinDepthOfBinaryTreeTest {

    MinDepthOfBinaryTree minDepthOfBinaryTree;

    @Before
    public void setUp() throws Exception {
        minDepthOfBinaryTree = new MinDepthOfBinaryTree();
    }

    @Test
    public void testMinDepth() throws Exception {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.left.left = new TreeNode(3);
        tree1.right = new TreeNode(2);

        assertEquals(2, minDepthOfBinaryTree.minDepth(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.right = new TreeNode(2);
        tree2.right.left = new TreeNode(2);

        assertEquals(3, minDepthOfBinaryTree.minDepth(tree2));
    }

}