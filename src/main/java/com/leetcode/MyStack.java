package com.leetcode;

import java.util.ArrayDeque;

/**
 * @author wangjf
 * @date 2019/2/24 0024.
 */
public class MyStack {

    private ArrayDeque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return this.queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }

}
