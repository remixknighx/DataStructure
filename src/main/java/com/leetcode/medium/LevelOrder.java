package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [102] Binary Tree Level Order Traversal
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = new LevelOrder().levelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        addToMap(map, root, 1);
        return new ArrayList<>(map.values());
    }

    private void addToMap(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.put(level, temp);
        } else {
            map.get(level).add(node.val);
        }

        addToMap(map, node.left, level+1);
        addToMap(map, node.right, level+1);
    }

}
