package com.leetcode;

import java.util.Stack;

/**
 * @author wangjf
 * @date 2019/2/24 0024.
 */
public class MyQueue {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return stack.firstElement();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
