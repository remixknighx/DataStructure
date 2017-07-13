package com.leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 * @link https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
