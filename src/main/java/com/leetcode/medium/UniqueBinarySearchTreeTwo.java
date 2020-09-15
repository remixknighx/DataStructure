package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 *
 * @link https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreeTwo {

    public static void main(String[] args) {
        List<TreeNode> result = new UniqueBinarySearchTreeTwo().generateTrees(1);
        System.out.println(result);
    }

    public List<TreeNode> generateTrees(int n) {

        if (n < 1) {
            return new ArrayList<>();
        }

        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(new TreeNode());
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    if (lnode.val != 0) {
                        root.left = lnode;
                    }
                    if (rnode.val != 0) {
                        root.right = rnode;
                    }
                    list.add(root);
                }
            }

        }

        return list;
    }

}
