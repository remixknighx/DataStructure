package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 区间合并算法，求区间并集
 *
 * @Auther: wangjianfeng
 * @Date: 2020/4/26 0026 15:36
 * @Description:
 */
public class IntervalUnionMain {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        merge(intervals);
    }

    private static List<List<Integer>> merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return null;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(intervals[0]).boxed().collect(Collectors.toList()));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            List<Integer> lastInterval = result.get(count);
            if (lastInterval.get(1) >= intervals[i][0]) {
                if (lastInterval.get(1) <= intervals[i][1]) {
                    lastInterval.set(1, intervals[i][1]);
                }
            } else {
                count += 1;
                result.add(Arrays.stream(intervals[i]).boxed().collect(Collectors.toList()));
            }
        }
        return result;
    }

}
