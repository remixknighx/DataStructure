package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [144] Binary Tree Preorder Traversal
 * @link https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(new BinaryTreePreorder().preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.remove(0);
            result.add(head.val);
            if (head.right != null) {
                queue.add(0, head.right);
            }
            if (head.left != null) {
                queue.add(0, head.left);
            }
        }

        return result;
    }

}
