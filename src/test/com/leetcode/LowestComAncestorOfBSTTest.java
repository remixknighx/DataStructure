package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangj on 2017/7/25 0025.
 */
public class LowestComAncestorOfBSTTest {

    LowestComAncestorOfBST lowestComAncestorOfBST;

    @Before
    public void setUp() throws Exception {
        lowestComAncestorOfBST = new LowestComAncestorOfBST();
    }

    @Test
    public void testLowestCommonAncestor() throws Exception {
        /**
         *           6
         *         /  \
         *        2    8
         *      /  \  /  \
         *     0   4 7   9
         *       /  \
         *      3    5
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        assertEquals(6, lowestComAncestorOfBST.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(9)).val);
        assertEquals(8, lowestComAncestorOfBST.lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9)).val);
        assertEquals(2, lowestComAncestorOfBST.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5)).val);
    }

}