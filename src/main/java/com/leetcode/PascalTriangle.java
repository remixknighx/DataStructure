package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * @link https://leetcode.com/problems/pascals-triangle/#/description
 *
 * @author wangjf
 * @date 2017/7/14.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new PascalTriangle().generate(6);

        for (List<Integer> singleRow: triangle) {
            for (Integer singleNum: singleRow) {
                System.out.print(singleNum + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (numRows == 0) {
            return result;
        }

        int[][] triangle = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        // 将二维数组转换为List<List<Integer>>类型
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new LinkedList<Integer>();
            for (int j = 0; j < numRows; j++) {
                if (triangle[i][j] != 0) {
                    row.add(triangle[i][j]);
                }
            }
            result.add(row);
        }

        return result;
    }

}
