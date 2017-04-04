package com.bill.queue;

import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class BillArrayQueue<T> {

    /**
     * ��ʼ����
     * */
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * ��ͷ
     * */
    private int front = 0;

    /**
     * ��β
     * */
    private int rear = -1;

    private T[] items;

    /**
     * ���������
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
            throw new NoSuchElementException("�ö���Ϊ��");
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
