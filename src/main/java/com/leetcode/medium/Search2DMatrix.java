package com.leetcode.medium;

/**
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class Search2DMatrix {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][col-1]) {
                int left = 0, right = col - 1;
                while (left <= right) {
                    int mid = left + (right-left) / 2;
                    if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }
}
