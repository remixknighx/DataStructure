package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * [54] Spiral Matrix
 * @link https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new SpiralOrder().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        addSpiralOrder(result, matrix, 0, 0, used);
        return result;
    }

    private void addSpiralOrder(List<Integer> result, int[][] matrix, int startRow, int startCol, boolean[][] used) {
        for (int j = startCol; j < matrix[0].length - startCol; j++) {
            if (used[startRow][j]) {
                return;
            }
            used[startRow][j] = true;
            result.add(matrix[startRow][j]);
        }

        for (int i = startRow + 1; i < matrix.length - startRow; i++) {
            if (used[i][matrix[0].length - startCol - 1]) {
                return;
            }
            used[i][matrix[0].length - startCol - 1] = true;
            result.add(matrix[i][matrix[0].length - startCol - 1]);
        }

        for (int j = matrix[0].length - startCol - 2; j >= startCol; j--) {
            if (used[matrix.length - startRow - 1][j]) {
                return;
            }
            used[matrix.length - startRow - 1][j] = true;
            result.add(matrix[matrix.length - startRow - 1][j]);
        }

        for (int i = matrix.length - startRow - 2; i > startRow; i--) {
            if (used[i][startCol]) {
                return;
            }
            used[i][startCol] = true;
            result.add(matrix[i][startCol]);
        }
        if (startRow + 1 >= used.length || startCol + 1 >= used[0].length || used[startRow + 1][startCol + 1]) {
            return;
        }

        addSpiralOrder(result, matrix, startRow + 1, startCol + 1, used);
    }
}
