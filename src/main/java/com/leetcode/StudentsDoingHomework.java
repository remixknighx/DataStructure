package com.leetcode;

/**
 * 1450. Number of Students Doing Homework at a Given Time
 * @link https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class StudentsDoingHomework {

	public static void main(String[] args) {

	}

	class Solution {
		public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
			int nfs = 0;
			for (int i = 0; i < startTime.length; i++) {
				if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
					nfs++;
				}
			}

			return nfs;
		}
	}

}


