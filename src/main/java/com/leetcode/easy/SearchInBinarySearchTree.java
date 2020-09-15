package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 * @link https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = new Solution().searchBST(root, 5);
        System.out.println(result);
    }

}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftResult = searchBST(root.left, val);
        TreeNode rightResult = searchBST(root.right, val);
        if (leftResult != null) {
            return leftResult;
        } else if (rightResult != null) {
            return rightResult;
        } else {
            return null;
        }

    }
}
