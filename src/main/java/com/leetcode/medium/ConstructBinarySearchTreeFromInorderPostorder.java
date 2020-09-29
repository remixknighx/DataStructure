package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 * @link https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class ConstructBinarySearchTreeFromInorderPostorder {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new ConstructBinarySearchTreeFromInorderPostorder().buildTree(inorder, postorder);
        System.out.println(root);
    }

    int rootIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIdx = inorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd || rootIdx < 0) {
            return null;
        }

        int rootVal = postorder[rootIdx--];
        TreeNode root = new TreeNode(rootVal);
        int inordeIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inordeIdx = i;
                break;
            }
        }

        root.right = helper(inorder, postorder, inordeIdx + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, inordeIdx - 1);
        return root;
    }

}
