package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * @link https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class MinDepthOfBinaryTree {

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
