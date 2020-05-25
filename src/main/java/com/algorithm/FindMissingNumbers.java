package com.algorithm;

/**
 * 寻找消失的元素
 */
public class FindMissingNumbers {

	public static void main(String[] args) {
		int[] nums = {0,3,1,4};
		System.out.println(missingNumber2(nums));
	}

	/**
	 * 使用位运算查找消失的元素
	 * 原理：一个数和它本身做异或运算结果为 0，一个数和 0 做异或运算还是它本身。
	 */
	private static int missingNumber1(int[] nums) {
		int n = nums.length;
		int res = 0;
		// 先和新补的索引异或一下
		res ^= n;
		// 和其他的元素、索引做异或
		for (int i = 0; i < n; i++) {
			res ^= i ^ nums[i];
		}
		return res;
	}

	/**
	 * 索引补位求和，并减去对应的数组和，所得结果为缺失的元素
	 */
	private static int missingNumber2(int[] nums) {
		int n = nums.length;
		int res = 0;
		// 新补的索引
		res += n;
		// 剩下索引和元素的差加起来
		for (int i = 0; i < n; i++) {
			res += i - nums[i];
		}
		return res;
	}

}
