package com.leetcode;

import com.leetcode.easy.SameTree;
import com.leetcode.easy.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/12.
 */
public class SameTreeTest {

    SameTree sameTree;

    @Before
    public void setUp() throws Exception {
        sameTree = new SameTree();
    }

    @Test
    public void testIsSameTree() throws Exception {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.right = new TreeNode(4);
        tree1.left.right.right = new TreeNode(5);
        tree1.right = new TreeNode(3);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(4);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.left.right = new TreeNode(4);
        tree2.left.right.right = new TreeNode(5);
        tree2.right = new TreeNode(3);
        tree2.right.left = new TreeNode(4);
        tree2.right.right = new TreeNode(4);

        assertTrue(sameTree.isSameTree(tree1, tree2));

        TreeNode tree3 = new TreeNode(12);
        tree3.right = new TreeNode(-60);

        TreeNode tree4 = new TreeNode(12);
        tree4.right = new TreeNode(72);

        assertFalse(sameTree.isSameTree(tree3, tree4));
    }

}