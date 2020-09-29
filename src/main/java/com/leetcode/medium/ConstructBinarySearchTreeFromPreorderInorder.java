package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 * @link https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class ConstructBinarySearchTreeFromPreorderInorder {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = new ConstructBinarySearchTreeFromPreorderInorder().buildTree(preorder, inorder);
        System.out.println(result);
    }

    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootVal = preorder[i++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIdx = 0;
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == rootVal) {
                inorderIdx = j;
                break;
            }
        }
        root.left = helper(preorder, inorder, inorderStart, inorderIdx - 1);
        root.right = helper(preorder, inorder, inorderIdx+1, inorderEnd);
        return root;
    }

}
