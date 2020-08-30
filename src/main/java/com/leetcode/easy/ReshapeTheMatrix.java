package com.leetcode.easy;

/**
 * 566. Reshape the Matrix
 * @link https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeTheMatrix {

	public static void main(String[] args) {
		int[][] nums = {{1, 2}, {3, 4}};
		int r = 1, c = 4;
		System.out.println(new ReshapeTheMatrix().matrixReshape(nums, r, c));
	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		// 无法转换成满足要求的二维数组
		if (nums.length * nums[0].length < r * c) {
			return nums;
		}

		int[][] result = new int[r][c];
		int rowCount = 0;
		int colCount = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				result[rowCount][colCount] = nums[i][j];
				colCount++;
				if (colCount == c) {
					rowCount++;
					colCount = 0;
				}
			}
		}

		return result;
	}

}
