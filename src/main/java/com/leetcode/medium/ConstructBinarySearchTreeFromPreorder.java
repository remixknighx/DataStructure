package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * [1008] Construct Binary Search Tree from Preorder Traversal
 * @link https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 */
public class ConstructBinarySearchTreeFromPreorder {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode result = new ConstructBinarySearchTreeFromPreorder().bstFromPreorder(preorder);
        System.out.println(result);
    }

    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }

}
