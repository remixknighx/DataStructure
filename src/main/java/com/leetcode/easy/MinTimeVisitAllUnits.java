package com.leetcode.easy;

/**
 * [1266] Minimum Time Visiting All Points
 * @link https://leetcode.com/problems/minimum-time-visiting-all-points/description/
 */
public class MinTimeVisitAllUnits {

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length - 1; i++) {
            count += calculateDistance(points[i], points[i+1]);
        }
        return count;
    }

    private int calculateDistance(int[] point1, int[] point2) {
        return Math.max(Math.abs(point2[0] - point1[0]), Math.abs(point2[1] - point1[1]));
    }

}
