package com.algorithm;

import java.util.*;

/**
 * 队列中的元素单调递增（或递减）
 *
 * @author wangjianfeng
 */
public class MonotonicQueueMain {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(Arrays.asList(1,3,-1,-3,5,3,6,7), 3));
    }

    private static List<Integer> maxSlidingWindow(List<Integer> nums, int k) {
        MonotonicQueue<Integer> window = new MonotonicQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (i < k-1) {
                window.push(nums.get(i));
            } else {
                window.push(nums.get(i));
                result.add(window.max());
                window.pop(nums.get(i-k+1));
            }
        }

        return result;
    }
}

class MonotonicQueue<E extends Comparable<E>> {

    private Deque<E> deque;

    private static int DEFAULT_SIZE = 15;

    public MonotonicQueue(){
        this(DEFAULT_SIZE);
    }

    public MonotonicQueue(int size) {
        deque = new ArrayDeque<>(size);
    }

    public void push(E e) {
        while (!deque.isEmpty() && less(deque.getLast(), e)) {
            deque.pollLast();
        }
        deque.addLast(e);
    }

    public E max() {
        return deque.getFirst();
    }

    public void pop(E e) {
        if (!deque.isEmpty() && isEqual(deque.getFirst(), e)) {
            deque.removeFirst();
        }
    }

    private boolean isEqual(E e1, E e2) {
        return e1.compareTo(e2) == 0;
    }

    private boolean less(E e1, E e2) {
        return e1.compareTo(e2) < 0;
    }

}
