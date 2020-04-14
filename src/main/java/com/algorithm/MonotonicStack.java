package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈实际上就是栈，只是利用了一些巧妙的逻辑，使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）。
 */
public class MonotonicStack {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(nextGreaterElement(Arrays.asList(2, 1, 2, 4, 3))));
        System.out.println(Arrays.asList(circleNextGreatElement(Arrays.asList(2, 1, 2, 4, 3))));
    }

    private static Integer[] nextGreaterElement(List<Integer> nums) {
        Integer[] result = new Integer[nums.size()];

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.size()-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums.get(i)) {
                stack.pop();
            }

            result[i] = stack.empty()? -1: stack.peek();

            stack.push(nums.get(i));
        }

        return result;
    }

    private static Integer[] circleNextGreatElement(List<Integer> nums) {
        int n = nums.size();
        Integer[] result = new Integer[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums.get(i % n)) {
                stack.pop();
            }

            result[i % n] = stack.empty() ? -1 : stack.peek();

            stack.push(nums.get(i % n));
        }

        return result;
    }

}
