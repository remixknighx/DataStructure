package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/7.
 */
public class MergeTwoBinaryTreesTest {

    MergeTwoBinaryTrees.TreeNode tree1;
    MergeTwoBinaryTrees.TreeNode tree2;

    @Before
    public void setUp() throws Exception {
        tree1 = new MergeTwoBinaryTrees.TreeNode(1);
        tree1.setLeft(new MergeTwoBinaryTrees.TreeNode(3).setLeft(new MergeTwoBinaryTrees.TreeNode(5)));
        tree1.setRight(new MergeTwoBinaryTrees.TreeNode(2));

        tree2 = new MergeTwoBinaryTrees.TreeNode(2);
        tree2.setLeft(new MergeTwoBinaryTrees.TreeNode(1).setRight(new MergeTwoBinaryTrees.TreeNode(4)));
        tree2.setLeft(new MergeTwoBinaryTrees.TreeNode(3).setRight(new MergeTwoBinaryTrees.TreeNode(7)));
    }

    @Test
    public void testMergeTrees() throws Exception {

    }

}