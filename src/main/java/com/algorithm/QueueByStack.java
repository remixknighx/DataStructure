package com.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


public class QueueByStack {

    public static void main(String[] args) {

    }

}

/**
 * 用栈实现队列
 */
class MyQueue<E> {

    private Stack<E> s1;
    private Stack<E> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** 添加元素到队尾 */
    public void push(E e){
        s1.push(e);
    }

    /** 删除队头的元素并返回 */
    public E pop(){
        peek();
        return s2.pop();
    }

    /** 返回队头元素 */
    public E peek(){
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** 判断队列是否为空 */
    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }

}

/**
 * 用队列实现栈
 */
class MyStack<E> {

    Queue<E> q = new ArrayDeque<>();

    E topELement;

    /** 添加元素到栈顶 */
    public void push(E e) {
        q.offer(e);
        topELement = e;
    }

    /**
     * 删除栈顶的元素并返回
     * 把队列前面的都取出来再加入队尾，让之前的队尾元素排到队头
     */
    public E pop() {
        int size = q.size();
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        topELement = q.poll();
        q.offer(topELement);
        return q.poll();
    }

    /** 返回栈顶元素 */
    public E top() {
        return topELement;
    }

    /** 判断栈是否为空 */
    public boolean empty() {
        return q.isEmpty();
    }
}
