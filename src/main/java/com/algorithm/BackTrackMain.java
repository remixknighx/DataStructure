package com.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 */
public class BackTrackMain {

    public static void main(String[] args) {
        int[][] result = new NQueen().solveNQueens(8);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

}

/**
 * 使用回溯算法解决全排列问题
 */
class AllArrangeMent {

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

}

/**
 * N皇後問題
 */
class NQueen {

    int[][] res = null;

    public int[][] solveNQueens(int n) {
        res = new int[n][n];
        backtrack(res, 0);
        return res;
    }

    private void backtrack(int[][] board, int row) {
        if (row == board.length) {
            res = board;
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';

            backtrack(board, row);

            board[row][col] = '.';

        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        int n = board[row].length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

}

