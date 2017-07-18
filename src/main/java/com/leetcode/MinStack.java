package com.leetcode;

import java.util.Stack;

/**
 * 155. Min Stack
 * @link https://leetcode.com/problems/min-stack/#/description
 *
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top(){
        minStack.peek();
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
