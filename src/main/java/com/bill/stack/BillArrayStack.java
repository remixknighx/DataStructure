package com.bill.stack;

import java.util.NoSuchElementException;

/**
 * 使用数组方式实现的堆栈
 */
public class BillArrayStack<T> {

    private static final int DEFAULT_SIZE = 10;

    private T[] items;

    private int count = 0;

    public BillArrayStack() {
        items = (T[]) new Object[DEFAULT_SIZE ];
    }

    /**
     * 进栈操作
     */
    public void push(T stack){
        if(count == size()){
            enlargeStack();
        }

        items[count++] = stack;
    }

    /**
     * 出栈操作
     */
    public T pop(){
        if(count == 0){
            throw new NoSuchElementException();
        }

        return items[--count];
    }

    private void enlargeStack(){
        T[] newItems = (T[]) new Object[2*items.length];

        for(int i = 0; i < items.length; i++){
            newItems[i] = items[i];
        }

        items = newItems;
    }

    public int size(){
        return items.length;
    }
}


