package com.leetcode;

/**
 * 226. Invert Binary Tree
 * @link https://leetcode.com/problems/invert-binary-tree/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 24 21:17
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        /**
         *        4                      4
         *      /  \                   /  \
         *     2    7      --->       7    2
         *   / \   / \              / \   / \
         *  1  3  6  9             9  6  3  1
         */
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(7);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(9);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertTree = invertBinaryTree.invertTree(tree);
        System.out.println(invertTree.val);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode invertedTree = root;

        TreeNode temp = invertedTree.left;
        invertedTree.left = invertedTree.right;
        invertedTree.right = temp;

        invertTree(invertedTree.left);
        invertTree(invertedTree.right);

        return invertedTree;
    }

}
