package com.leetcode.medium;

import java.util.*;

/**
 * [56] Merge Intervals
 * @link https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        int[][] result = new MergeIntervals().merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {// Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}
