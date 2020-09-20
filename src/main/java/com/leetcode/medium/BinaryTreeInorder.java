package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorder().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode top = list.remove(0);
            if (top.left == null && top.right == null) {
                result.add(top.val);
            } else {
                if (top.right != null) {
                    list.add(0, top.right);
                }
                list.add(0, new TreeNode(top.val));
                if (top.left != null) {
                    list.add(0, top.left);
                }
            }
        }

        return result;
    }

}
