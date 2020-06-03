package com.algorithm;

/**
 * koko偷香蕉
 */
public class StealBanana {

	public static void main(String[] args) {
		int[] piles = {30, 11, 23, 4, 20};
		int H = 5;
		System.out.println(minEatingSpeed(piles, H));
	}

	private static int minEatingSpeed(int[] piles, int H) {
		// 套用搜索左侧边界的算法框架
		int left = 1, right = getMax(piles) + 1;
		while (left < right) {
			// 防止溢出
			int mid = left + (right - left) / 2;
			if (canFinish(piles, mid, H)) {
				right = mid;
				break;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	// 时间复杂度 O(N)
	private static boolean canFinish(int[] piles, int speed, int H) {
		int time = 0;
		for (int n : piles) {
			time += timeOf(n, speed);
		}
		return time <= H;
	}

	private static int timeOf(int n, int speed) {
		return (n / speed) + ((n % speed > 0) ? 1 : 0);
	}

	private static int getMax(int[] piles) {
		int max = 0;
		for (int n : piles) {
			max = Math.max(n, max);
		}
		return max;
	}

}
