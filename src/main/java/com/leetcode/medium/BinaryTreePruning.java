package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * 814. Binary Tree Pruning
 * @link https://leetcode.com/problems/binary-tree-pruning/
 */
public class BinaryTreePruning {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeNode result = new BinaryTreePruning().pruneTree(root);
        System.out.println(result);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null && root.val == 0)) {
            return null;
        }
        TreeNode leftNode = pruneTree(root.left);
        TreeNode rightNode = pruneTree(root.right);
        if (leftNode == null && rightNode == null && root.val == 0) {
            return null;
        }
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = leftNode;
        newTree.right = rightNode;
        return newTree;
    }
}
