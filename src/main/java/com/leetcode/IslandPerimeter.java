package com.leetcode;

/**
 * @author wangjf
 * @date 2018/4/1 0001.
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                if(i == 0 || grid[i-1][j] == 0){
                    count++;
                }
                if(i == row - 1 || grid[i+1][j] == 0){
                    count++;
                }
                if(j == 0 || grid[i][j-1] == 0){
                    count++;
                }
                if(j == column - 1 || grid[i][j+1] == 0){
                    count++;
                }
            }
        }

        return count;
    }

}
