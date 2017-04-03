package com.bill.queue;

import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class BillArrayQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int front = 0;

    private int rear = 0;

    private T[] items;

    public BillArrayQueue(){
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void enqueue(T item){
        if(rear == items.length){
            enlargeQueue();
        }
        items[rear++] = item;
    }

    public T dequeue(){
        if(front == 0){
            throw new NoSuchElementException();
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
