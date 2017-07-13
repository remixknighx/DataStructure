package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class BalancedBinaryTreeTest {

    BalancedBinaryTree balancedBinaryTree;

    @Before
    public void setUp() throws Exception {
        balancedBinaryTree = new BalancedBinaryTree();
    }

    @Test
    public void testIsBalanced() throws Exception {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.left.left = new TreeNode(7);
        tree.right = new TreeNode(6);

        assertFalse(balancedBinaryTree.isBalanced(tree));

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(4);
        tree2.left.left = new TreeNode(5);
        tree2.right = new TreeNode(6);

        assertTrue(balancedBinaryTree.isBalanced(tree2));

        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(4);
        tree3.right = new TreeNode(6);

        assertTrue(balancedBinaryTree.isBalanced(tree3));
    }

}