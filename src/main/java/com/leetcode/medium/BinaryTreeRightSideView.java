package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 199. Binary Tree Right Side View
 * @link https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        helper(map, root, 0);
        for (int i = 0; i < map.keySet().size(); i++) {
            result.add(map.get(i));
        }

        return result;
    }

    private void helper(Map<Integer, Integer> map, TreeNode root, int level) {
        map.put(level, root.val);
        if (root.left != null) {
            helper(map, root.left, level + 1);
        }
        if (root.right != null) {
            helper(map, root.right, level + 1);
        }
    }

}
