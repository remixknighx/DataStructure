package com.leetcode.medium;

import java.util.List;

/**
 * [59] Spiral Matrix II
 * @link https://leetcode.com/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrixTwo {

    public static void main(String[] args) {
        int[][] result = new SpiralMatrixTwo().generateMatrix(3);
        System.out.println(result);
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        addToMatrix(result, 0, 0, 1);
        return result;
    }

    private void addToMatrix(int[][] matrix, int startRow, int startCol, int startNum) {
        for (int j = startCol; j < matrix[0].length - startCol; j++) {
            if (matrix[startRow][j] != 0) {
                return;
            }
            matrix[startRow][j] = startNum++;
        }

        for (int i = startRow + 1; i < matrix.length - startRow; i++) {
            if (matrix[i][matrix[0].length - startCol - 1] != 0) {
                return;
            }
            matrix[i][matrix[0].length - startCol - 1] = startNum++;
        }

        for (int j = matrix[0].length - startCol - 2; j >= startCol; j--) {
            if (matrix[matrix.length - startRow - 1][j] != 0) {
                return;
            }
            matrix[matrix.length - startRow - 1][j] = startNum++;
        }

        for (int i = matrix.length - startRow - 2; i > startRow; i--) {
            if (matrix[i][startCol] != 0) {
                return;
            }
            matrix[i][startCol] = startNum++;
        }
        if (startRow + 1 >= matrix.length || startCol + 1 >= matrix[0].length) {
            return;
        }

        addToMatrix(matrix, startRow + 1, startCol + 1, startNum);
    }

}
