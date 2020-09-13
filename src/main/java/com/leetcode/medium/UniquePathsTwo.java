package com.leetcode.medium;

/**
 * 63. Unique Paths II
 * @link https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsTwo {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{1, 0}, {0,0}};
        System.out.println(new UniquePathsTwo().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 1) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 1) {
                    return 0;
                }
            }
        }

        if (obstacleGrid[0].length == 1) {
            for (int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                map[i][0] = 0;
                break;
            } else {
                map[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                map[0][j] = 0;
                break;
            } else {
                map[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }

}
