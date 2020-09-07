package com.leetcode.medium;

/**
 * [11] Container With Most Water
 * @link https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        int result = 0;

        while (left <= right) {
            leftMaxHeight = Math.max(leftMaxHeight, height[left]);
            rightMaxHeight = Math.max(rightMaxHeight, height[right]);

            if (leftMaxHeight < rightMaxHeight) {
                result = Math.max(result, (right - left) * leftMaxHeight);
                left++;
            } else {
                result = Math.max(result, (right - left) * rightMaxHeight);
                right--;
            }
        }
        return result;
    }

}
