package com.leetcode.easy;

/**
 * @author wangjf
 * @date 2017/7/13.
 */
public class ConvertSortedArray2BinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode tree = new ConvertSortedArray2BinarySearchTree().sortedArrayToBST(nums);

        printTree(tree);
    }

    /**
     * ����������ķ�ʽ��ӡһ����������
     *
     * @param tree ����ӡ����
     */
    private static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }

        printTree(tree.left);
        System.out.println(tree.val);
        printTree(tree.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(nums[(start + end) / 2]);
        node.left = buildTree(nums, start, (start + end) / 2 - 1);
        node.right = buildTree(nums, (start + end) / 2 + 1, end);
        return node;

    }
}
