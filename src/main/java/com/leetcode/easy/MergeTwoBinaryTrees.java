package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * @link https://leetcode.com/problems/merge-two-binary-trees/#/description
 *
 * @author wangjf
 * @date 2017/06/17
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode mergedTree = mergeTwoBinaryTrees.mergeTrees(t1, t2);

        System.out.println(mergedTree.val);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (null != t1 && null != t2) {
            TreeNode newTree = null;
            newTree = new TreeNode(t1.val + t2.val);
            newTree.left = mergeTrees(t1.left, t2.left);
            newTree.right = mergeTrees(t1.right, t2.right);
            return newTree;
        }

        if (t1 != null) {
            return t1;
        }

        if (t2 != null) {
            return t2;
        }

        return null;
    }

}
