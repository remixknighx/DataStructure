package com.leetcode;

/**
 * 100. Same Tree
 * @link https://leetcode.com/problems/same-tree/#/description
 *
 * @author wangjf
 * @date 2017/7/12.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        }

        if(p.val == q.val) {
            if(p.left != null && q.left != null) {
                if (isSameTree(p.left, q.left)) {
                    return isSameTree(p.right, q.right);
                } else {
                    return false;
                }
            } else if(p.left == null && q.left == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
