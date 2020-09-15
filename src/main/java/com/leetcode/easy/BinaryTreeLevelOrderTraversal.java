package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 *
 * @author wangjf
 * @date 2017/7/13.
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.left.left = new TreeNode(10);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> list = new BinaryTreeLevelOrderTraversal().levelOrderBottom(tree);
        for (List<Integer> singleList: list) {
            for (Integer num: singleList) {
                System.out.println(num);
            }
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.addFirst(level);
        }

        return result;
    }

}
