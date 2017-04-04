package com.bill.queue;

import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class BillArrayQueue<T> {

    /**
     * 初始容量
     * */
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * 队头
     * */
    private int front = 0;

    /**
     * 队尾
     * */
    private int rear = -1;

    private T[] items;

    /**
     * 数据项个数
     * */
    private int nItems;

    public BillArrayQueue(){
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void enqueue(T item){
        if(rear-front == items.length-1){
            enlargeQueue();
        }
        items[++rear] = item;
    }

    public T dequeue(){
        if(items[front] == null){
            throw new NoSuchElementException("该队列为空");
        }

        return items[front++];
    }

    private void enlargeQueue(){
        T[] newItems = (T[]) new Object[2*items.length];

        for(int i = 0; i < items.length; i++){
            newItems[i] = items[i];
        }

        items = newItems;
    }

}
