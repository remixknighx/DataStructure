package com.leetcode.easy;

/**
 * 112. Path Sum
 * @link https://leetcode.com/problems/path-sum/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        System.out.println(new PathSum().hasPathSum(tree, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
