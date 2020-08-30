package com.leetcode;

import com.leetcode.easy.SymmetricTree;
import com.leetcode.easy.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class SymmetricTreeTest {

    SymmetricTree symmetricTree;

    @Before
    public void setUp() throws Exception {
        symmetricTree = new SymmetricTree();
    }

    @Test
    public void testIsSymmetric() throws Exception {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right = new TreeNode(2);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(3);

        assertTrue(symmetricTree.isSymmetric(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.left.right = new TreeNode(3);
        tree2.right = new TreeNode(2);
        tree2.right.right = new TreeNode(3);

        assertFalse(symmetricTree.isSymmetric(tree2));
    }

}