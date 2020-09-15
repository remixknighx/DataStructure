package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 110. Balanced Binary Tree
 * @link https://leetcode.com/problems/balanced-binary-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(4);
        tree2.left.left = new TreeNode(5);
        tree2.right = new TreeNode(6);

        System.out.println(new BalancedBinaryTree().isBalanced(tree2));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isBalanced(root.left) && isBalanced(root.right)) {
            return Math.abs(findDepth(root.left) - findDepth(root.right)) <= 1;
        } else {
            return false;
        }
    }

    private int findDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int left = findDepth(tree.left);
        int right = findDepth(tree.right);
        return Math.max(left, right) + 1;
    }

}
