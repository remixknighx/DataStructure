package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [145] Binary Tree Postorder Traversal
 * @link https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
public class BinaryTreePostorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreePostorder().postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.remove(0);
            result.add(0, head.val);
            if (head.left != null) {
                queue.add(0, head.left);
            }
            if (head.right != null) {
                queue.add(0, head.right);
            }
        }

        return result;
    }

}
