package com.leetcode.easy;

/**
 * 101. Symmetric Tree
 * @link https://leetcode.com/problems/symmetric-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.left.right.left = new TreeNode(5);
        tree1.right = new TreeNode(2);
        tree1.right.left = new TreeNode(4);
        tree1.right.left.right = new TreeNode(5);
        tree1.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(tree1));
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2) {
        if(treeNode1 == null && treeNode2 == null) {
            return true;
        } else if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        return treeNode1.val == treeNode2.val && isSymmetric(treeNode1.left, treeNode2.right) && isSymmetric(treeNode1.right, treeNode2.left);
    }

}
