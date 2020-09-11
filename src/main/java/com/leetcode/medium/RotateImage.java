package com.leetcode.medium;

/**
 * [48] Rotate Image
 * @link https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().rotate(matrix);
    }

    /**
     * 1  2  3      1  4  7     7  4  1
     * 4  5  6  ->  2  5  8  -> 8  5  2
     * 7  8  9      3  6  9     9  6  3Group Anagrams
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

}
