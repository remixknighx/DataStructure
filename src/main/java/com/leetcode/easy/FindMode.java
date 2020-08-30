package com.leetcode.easy;

import java.util.Arrays;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * @author wangjf
 * @link https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 * @date 2018/8/12 0012.
 */
public class FindMode {

    int currVal = 0;
    int currCount = 0;
    int maxCount = 0;
    int modeCount = 0;

    int[] modes;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.asList(new FindMode().findMode(root)));
    }

    public int[] findMode(TreeNode root) {
        inOrder(root);
        modes = new int[modeCount];
        currCount = 0;
        modeCount = 0;
        inOrder(root);
        return modes;
    }

    public void handleValue(int val) {
        if (currVal != val) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        handleValue(root.val);
        inOrder(root.right);
    }

}
