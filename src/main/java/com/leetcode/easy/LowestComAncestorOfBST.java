package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 25 20:27
 */
public class LowestComAncestorOfBST {

    public static void main(String[] args) {
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

        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        System.out.println(new LowestComAncestorOfBST().lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

}
