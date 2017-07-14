package com.leetcode;

import java.util.*;

/**
 * 119. Pascal's Triangle II
 * @link https://leetcode.com/problems/pascals-triangle-ii/#/description
 *
 * @author wangjf
 * @date 2017/7/14.
 */
public class PascalTriangleTwo {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();

        if (rowIndex == 0) {
            row.add(1);
            return row;
        }

        int[][] triangle = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        for (int k = 0; k < triangle[rowIndex].length; k++) {
            if (triangle[rowIndex][k] != 0) {
                row.add(triangle[rowIndex][k]);
            }
        }

        return row;
    }

}
