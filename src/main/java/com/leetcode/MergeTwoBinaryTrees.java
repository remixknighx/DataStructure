package com.leetcode;

/**
 * Exercise 617 Merge Two Binary Trees
 * @link https://leetcode.com/problems/merge-two-binary-trees/#/description
 *
 * @author wangjf
 * @date 2017 - 06 - 17 17:11
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

    }


    /* inner class */
    private class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
