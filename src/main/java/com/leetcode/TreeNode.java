package com.leetcode;

/**
 * @author wangjf
 * @date 2017/7/12.
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
