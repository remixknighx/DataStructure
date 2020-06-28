package com.algorithm.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 高楼扔鸡蛋
 * @author wangjianfeng
 */
public class DropEgg {

    public static void main(String[] args) {

    }

}


class DropEggFloor {

    private Map<List<Integer>, Integer> memo;

    public DropEggFloor() {
        memo = new HashMap<>();
    }

    /**
     * 总时间复杂度是 O(K*N^2), 空间复杂度 O(KN)。
     */
    public Integer findMinFloor(Integer k, Integer n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(Arrays.asList(k, n))) {
            return memo.get(Arrays.asList(k, n));
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            result = Math.min(result, Math.max(
                    this.findMinFloor(k, n - i), // 没碎
                    this.findMinFloor(k - 1, i - 1)) // 碎
                    + 1);
        }

        memo.put(Arrays.asList(k, n), result);
        return result;
    }

    /**
     * 时间复杂度是 O(K*N*logN), 空间复杂度 O(KN)
     */
    public Integer binarySearch(Integer k, Integer n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(Arrays.asList(k, n))) {
            return memo.get(Arrays.asList(k, n));
        }

        int result = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        while (low <= high) {
            int middle = (low + high) / 2;
            int broken = this.binarySearch(k - 1, middle - 1); // 碎
            int notBroken = this.binarySearch(k, n - middle); // 没碎
            if (broken > notBroken) {
                high = middle - 1;
                result = Math.min(result, broken + 1);
            } else {
                low = middle + 1;
                result = Math.min(result, notBroken + 1);
            }
        }

        memo.put(Arrays.asList(k, n), result);
        return result;
    }

}
