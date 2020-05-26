package com.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 调度考生的座位
 */
public class SeatAdjust {

	public static void main(String[] args) {
		ExamRoom examRoom = new ExamRoom(6);
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
	}

}

class ExamRoom {

	/**
	 * 将端点 p 映射到以 p 为左端点的线段
	 */
	private Map<Integer, int[]> startMap;
	/**
	 * 将端点 p 映射到以 p 为右端点的线段
	 */
	private Map<Integer, int[]> endMap;
	/**
	 * 根据线段长度从小到大存放所有线段
	 */
	private TreeSet<int[]> pq;
	private int N;

	/**
	 * 构造函数，传入座位总数 N
	 */
	public ExamRoom(int N) {
		this.N = N;
		startMap = new HashMap<>();
		endMap = new HashMap<>();
		pq = new TreeSet<>((a, b) -> {
			// 算出两个线段的长度
			int distA = distance(a);
			int distB = distance(b);
			// 长度更长的更大，排后面
			return distA - distB;
		});
		// 在有序集合中先放一个虚拟线段
		addInterval(new int[]{-1, N});
	}

	/**
	 * 来了一名考生，返回你给他分配的座位
	 */
	public int seat() {
		// 从有序集合拿出最长的线段
		int[] longest = pq.last();
		int x = longest[0];
		int y = longest[1];
		int seat;
		if (x == -1) { // 情况一
			seat = 0;
		} else if (y == N) { // 情况二
			seat = N - 1;
		} else { // 情况三
			seat = (y - x) / 2 + x;
		}
		// 将最长的线段分成两段
		int[] left = new int[]{x, seat};
		int[] right = new int[]{seat, y};
		removeInterval(longest);
		addInterval(left);
		addInterval(right);
		return seat;
	}

	/**
	 * 坐在 p 位置的考生离开了
	 * 可以认为 p 位置一定坐有考生
	 */
	public void leave(int p) {
		// 将 p 左右的线段找出来
		int[] right = startMap.get(p);
		int[] left = endMap.get(p);
		// 合并两个线段成为一个线段
		int[] merged = new int[]{left[0], right[1]};
		removeInterval(left);
		removeInterval(right);
		addInterval(merged);
	}

	/**
	 * 去除一个线段
	 */
	private void removeInterval(int[] intv) {
		pq.remove(intv);
		startMap.remove(intv[0]);
		endMap.remove(intv[1]);
	}

	/**
	 * 增加一个线段
	 */
	private void addInterval(int[] intv) {
		pq.add(intv);
		startMap.put(intv[0], intv);
		endMap.put(intv[1], intv);
	}

	/**
	 * 计算一个线段的长度
	 */
	private int distance(int[] intv) {
		return intv[1] - intv[0] - 1;
	}

}