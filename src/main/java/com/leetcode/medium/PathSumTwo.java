package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [113] Path Sum II
 * @link https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumTwo {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//        root.right.left = new TreeNode(13);
//        System.out.println(new PathSumTwo().pathSum(root, 22));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        System.out.println(new PathSumTwo().pathSum(root, -1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> single, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        single.add(root.val);
        if (sum - root.val == 0 && (root.left == null && root.right == null)) {
            result.add(new ArrayList<>(single));
            return;
        } else if (Math.abs(sum - root.val) >= 0) {
            if (root.left != null) {
                helper(root.left, sum - root.val, single, result);
                single.remove(single.size() - 1);
            }
            if (root.right != null) {
                helper(root.right, sum - root.val, single, result);
                single.remove(single.size() - 1);
            }
        }
    }

}
