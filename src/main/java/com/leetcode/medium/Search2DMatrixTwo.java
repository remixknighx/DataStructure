package com.leetcode.medium;

/**
 * 240. Search a 2D Matrix II
 * @link https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrixTwo {

	public static void main(String[] args) {
  		int[][] matrix = {{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		System.out.println(new Search2DMatrixTwo().searchMatrix(matrix, 5));
		System.out.println(new Search2DMatrixTwo().searchMatrix(matrix, 20));
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
			}
		}

		return false;
	}

}
