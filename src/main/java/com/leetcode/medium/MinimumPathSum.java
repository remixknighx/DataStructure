package com.leetcode.medium;

/**
 * [64] Minimum Path Sum
 * @link https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = new MinimumPathSum().minPathSum(nums);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] map = new int[row][col];
        map[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            map[i][0] = map[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            map[0][i] = map[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                map[i][j] = Math.min(map[i-1][j], map[i][j-1]) + grid[i][j];
            }
        }

        return map[row-1][col-1];
    }

}
