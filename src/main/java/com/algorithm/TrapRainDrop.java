package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 接雨水
 */
public class TrapRainDrop {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        System.out.println(memoTrap(nums));
    }

    /**
     * 备忘录解法，时间复杂度和空间复杂度均为O(N)
     */
    private static int memoTrap(List<Integer> height) {
        if (height.isEmpty()) {
            return 0;
        }
        int n = height.size();
        int ans = 0;
        // 数组充当备忘录
        List<Integer> lMax = new ArrayList<>();
        List<Integer> rMax = new ArrayList<>();
        // 初始化 base case
        lMax.set(0, height.get(0));
        rMax.set(n-1, height.get(n-1));
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            lMax.set(i, Math.max(height.get(i), lMax.get(i-1)));
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            rMax.set(i, Math.max(height.get(i), rMax.get(i-1)));
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            ans += Math.min(lMax.get(i), rMax.get(i)) - height.get(i);
        return ans;
    }

    /**
     * 双指针解法，时间复杂度O(N)，空间复杂度O(1)
     */
    private static int trap(List<Integer> height) {
        if (height.isEmpty()) {
            return 0;
        }
        int n = height.size();
        int left = 0, right = n - 1;
        int ans = 0;

        int l_max = height.get(0);
        int r_max = height.get(n-1);

        while (left <= right) {
            l_max = Math.max(l_max, height.get(left));
            r_max = Math.max(r_max, height.get(right));

            // ans += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                ans += l_max - height.get(left);
                left++;
            } else {
                ans += r_max - height.get(right);
                right--;
            }
        }
        return ans;
    }

}
