package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [103] Binary Tree Zigzag Level Order Traversal
 * @link https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class ZigZagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = new ZigZagLevelOrder().zigzagLevelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        addToMap(map, root, 1, true);
        return new ArrayList<>(map.values());
    }

    private void addToMap(Map<Integer, List<Integer>> map, TreeNode node, int level, boolean flag) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.put(level, temp);
        } else {
            if (flag) {
                map.get(level).add(node.val);
            } else {
                map.get(level).add(0, node.val);
            }
        }

        addToMap(map, node.left, level+1, !flag);
        addToMap(map, node.right, level+1, !flag);
    }

}
