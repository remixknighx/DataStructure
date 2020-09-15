package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 437. Path Sum 3
 * @link https://leetcode.com/problems/path-sum-iii/description/
 *
 * @author wangjf
 * @date 2017/10/6 0006.
 */
public class PathSum3 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(-3);
        tree.right.right = new TreeNode(11);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(2);
        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);
        tree.left.right.right = new TreeNode(1);

        System.out.println(new PathSum3().pathSum(tree, 8));
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int res = 0;

        if(root == null) {
            return res;
        }

        if (sum == root.val) {
            res ++;
        }

        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);

        return res;
    }
}
