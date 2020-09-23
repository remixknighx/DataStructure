package com.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * [260] Single Number III
 * @link https://leetcode.com/problems/single-number-iii/description/
 */
public class SingleNumberThree {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] result = new SingleNumberThree().singleNumber(nums);
        System.out.println(result);
    }

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);

        for (int num: nums) {
            if (stack.empty()) {
                stack.push(num);
            } else {
                int top = stack.peek();
                if (top == num) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

}
