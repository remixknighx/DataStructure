package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [129] Sum Root to Leaf Numbers
 * @link https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class SumRootToLeafNumber {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        System.out.println(new SumRootToLeafNumber().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> numList = new ArrayList<>();

        helper(numList, root, new StringBuilder());

        int result = 0;
        for (int num: numList) {
            result += num;
        }
        return result;
    }

    private void helper(List<Integer> numList, TreeNode root, StringBuilder numStr) {

        if (root == null) {
            return;
        }

        numStr.append(root.val);
        if (root.left == null && root.right == null) {
            numList.add(Integer.valueOf(numStr.toString()));
            return;
        }

        helper(numList, root.left, numStr);
        if (root.left != null) {
            numStr.deleteCharAt(numStr.length() - 1);
        }

        helper(numList, root.right, numStr);
        if (root.right != null) {
            numStr.deleteCharAt(numStr.length() - 1);
        }
    }

}
