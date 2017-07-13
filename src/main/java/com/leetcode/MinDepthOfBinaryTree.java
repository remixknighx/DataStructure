package com.leetcode;

/**
 * 111. Minimum Depth of Binary Tree
 * @link https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.left.left = new TreeNode(3);
        tree1.right = new TreeNode(2);

        System.out.println(new MinDepthOfBinaryTree().minDepth(tree1));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left == null || root.right == null) {
            return root.left == null? minDepth(root.right) + 1: minDepth(root.left) + 1;
        } else {
            return 1;
        }
    }

}
