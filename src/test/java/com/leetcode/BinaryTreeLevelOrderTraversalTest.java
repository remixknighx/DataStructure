package com.leetcode;

import com.leetcode.easy.BinaryTreeLevelOrderTraversal;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class BinaryTreeLevelOrderTraversalTest {

    BinaryTreeLevelOrderTraversal treeLevelOrderTraversal;

    @Before
    public void setUp() throws Exception {
        treeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    }

    @Test
    public void testLevelOrderBottom() throws Exception {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

    }

}