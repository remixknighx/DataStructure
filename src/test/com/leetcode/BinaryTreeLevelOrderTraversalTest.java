package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.*;

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