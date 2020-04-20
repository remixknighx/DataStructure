package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个问题的**最基本形式**是这样：给你一个数组和一个整数 `target`，可以保证数组中**存在**两个数的和为 `target`，请你返回这两个数的索引。
 */
public class TwoSumExercise {

    public static void main(String[] args) {

    }

    /**
     * 通过哈希表减少时间复杂度
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    private int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();
        // 构造一个哈希表：元素映射到相应的索引
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 nums[i] 本身
            if (index.containsKey(other) && index.get(other) != i)
                return new int[] {i, index.get(other)};
        }

        return new int[] {-1, -1};
    }

}

class TwoSum {
    Map<Integer, Integer> freq = new HashMap<>();

    /**
     * 时间复杂度O(1)
     */
    public void add(int number) {
        // 记录 number 出现的次数
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    /**
     * 时间复杂度和空间复杂度均为O(N)
     */
    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;
            // 情况一: `add` 了 `[3,3,2,5]` 之后，执行 `find(6)`，由于 3 出现了两次，3 + 3 = 6，所以返回 true。
            if (other == key && freq.get(key) > 1)
                return true;
            // 情况二: `add` 了 `[3,3,2,5]` 之后，执行 `find(7)`，那么 `key` 为 2，`other` 为 5 时算法可以返回 true。
            if (other != key && freq.containsKey(other))
                return true;
        }
        return false;
    }
}
