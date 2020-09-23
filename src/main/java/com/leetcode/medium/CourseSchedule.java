package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [207] Course Schedule
 * @link https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        // Array List 嵌套需要循环初始化
        List<List<Integer>> neighbor = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            neighbor.add(new ArrayList<>());
        }
        Deque<Integer> depandent = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        // 做一个入度表
        for (int[] courselist : prerequisites) {
            inDegree[courselist[0]] += 1;
            neighbor.get(courselist[1]).add(courselist[0]);
        }
        // 找出入度为0的课程
        for (int m = 0; m < numCourses; m++) {
            if (inDegree[m] == 0) {
                depandent.add(m);
            }
        }
        // 从入度为0的课程上起：
        while (!depandent.isEmpty()) {
            int current = depandent.removeLast();
            result[index] = current;
            index += 1;

            for (int x : neighbor.get(current)) {
                inDegree[x] -= 1;
                if (inDegree[x] == 0) {
                    depandent.add(x);
                }
            }
        }

        return index == numCourses;
    }

}
