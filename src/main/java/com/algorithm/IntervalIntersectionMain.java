package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间交集算法
 *
 * @Auther: wangjianfeng
 * @Date: 2020/4/26 0026 16:54
 * @Description:
 */
public class IntervalIntersectionMain {

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(0, 2));
        A.add(Arrays.asList(5, 10));
        A.add(Arrays.asList(13, 23));
        A.add(Arrays.asList(24, 25));

        List<List<Integer>> B = new ArrayList<>();
        B.add(Arrays.asList(1, 5));
        B.add(Arrays.asList(8, 12));
        B.add(Arrays.asList(15, 24));
        B.add(Arrays.asList(25, 26));

        System.out.println(intervalIntersection(A, B));
    }

    private static List<List<Integer>> intervalIntersection(List<List<Integer>> A, List<List<Integer>> B){
        int i = 0;
        int j = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            int a1 = A.get(i).get(0);
            int a2 = A.get(i).get(1);
            int b1 = B.get(j).get(0);
            int b2 = B.get(j).get(1);
            if (a2 >= b1 && b2 >= a1) {
                result.add(Arrays.asList(Math.max(b1, a1), Math.min(b2, a2)));
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }

}
