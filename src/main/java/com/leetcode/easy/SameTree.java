package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * 100. Same Tree
 * @link https://leetcode.com/problems/same-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/12.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
