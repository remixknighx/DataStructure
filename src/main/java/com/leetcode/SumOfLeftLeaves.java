package com.leetcode;

/**
 * 404. Sum of Left Leaves
 * @link https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * @author wangjf
 * @date 2017/8/23 0023.
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        /**
         *       3
         *      / \
         *     9   20
         *        / \
         *      15   7
         */
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(tree));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null) {
            TreeNode left = root.left;
            if (left.left == null && left.right == null) {
                sum += left.val;
            } else {
                sum += sumOfLeftLeaves(left);
            }
        }

        if (root.right != null) {
            TreeNode right = root.right;
            sum += sumOfLeftLeaves(right);
        }

        return sum;

    }

}
