package com.leetcode;

/**
 * 1539. Kth Missing Positive Number
 * @link https://leetcode.com/problems/kth-missing-positive-number/
 */
public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int k = 2;
		System.out.println(new KthMissingPositiveNumber().findKthPositive(arr, k));
	}

	public int findKthPositive(int[] arr, int k) {
		int count = 0;
		int index = 0;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (index < arr.length && arr[index] == i) {
				index++;
			} else {
				count++;
				if (count == k) {
					return i;
				}
			}
		}
		return 0;
	}

}
