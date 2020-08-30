package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * @link https://leetcode.com/problems/binary-tree-paths/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 25 21:25
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        /**
         *      1
         *    /  \
         *   2   3
         *    \
         *     5
         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> paths = binaryTreePaths.binaryTreePaths(tree);

        for (String path: paths) {
            System.out.println(path);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }

        // ���ú�������ķ�ʽ
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }

        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;
    }
}
