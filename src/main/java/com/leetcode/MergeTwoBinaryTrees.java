package com.leetcode;

/**
 * 617. Merge Two Binary Trees
 * @link https://leetcode.com/problems/merge-two-binary-trees/#/description
 *
 * @author wangjf
 * @date 2017/06/17
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.setLeft(new TreeNode(3).setLeft(new TreeNode(5)));
        tree1.setRight(new TreeNode(2));

        TreeNode tree2 = new TreeNode(2);
        tree2.setLeft(new TreeNode(1).setRight(new TreeNode(4)));
        tree2.setLeft(new TreeNode(3).setRight(new TreeNode(7)));

        TreeNode newTree = new MergeTwoBinaryTrees().mergeTrees(tree1, tree2);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return new TreeNode(4);
    }

    /* inner class */
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }

}
