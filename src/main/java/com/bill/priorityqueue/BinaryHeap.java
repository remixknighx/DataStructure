package com.bill.priorityqueue;

import java.util.Comparator;

/**
 * 二叉堆：<b>结构性</b>和<b>数据性</b>
 * 该例使用数组的方式实现二叉堆结构
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    /* private field */
    /**
     * 默认数组元素大小
     * */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 当前二叉堆尺寸大小
     * */
    private int currentSize = 0;

    /**
     * 保存元素的二叉堆数组
     * */
    private T[] array;

    /* public method */
    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity){
        array = (T[]) new Object[capacity];
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[]) new Comparator[(currentSize+2)*11/10];

        int i = 1;
        for (T item: items) {
            array[i++] = item;
        }
        buildHeap();
    }

    /**
     * 插入二叉堆中，同时保持堆元素的顺序
     *
     * @param element 待插入的堆元素
     * */
    public void insert(T element){
        if(currentSize == array.length-1){
            enlargeArray(array.length * 2 + 1);
        }

        // 进行上滤操作
        int hole = ++currentSize;
        while ((hole > 1) && (element.compareTo(array[hole / 2]) < 0)){
            array[hole] = array[hole/2];
            hole /= 2;
        }

        array[hole] = element;
    }

    /**
     * 返回优先队列中的最小值
     *
     * @return 返回二叉堆中的最小值
     * */
    public T deleteMin(){
        if(isEmpty()){
            throw new NullPointerException();
        }

        // 二叉堆中的最小元素总在树根处，即array[1]处
        T minItem = array[1];

        // 将数组中的最后一个元素放在树根处，并进行下滤操作
        // 使堆排序正常
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * 判断二叉堆是否为空
     *
     * @return 若为空堆，则返回true，反之则为false
     * */
    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * 清空二叉堆中的元素
     * */
    public void makeEmpty(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /* private method */
    /**
     * 下滤操作，将父节点不断地与子节点进行比较
     * 若父节点小于子节点，则进行交换
     *
     * @param hole
     * */
    private void percolateDown(int hole){
        int child;
        T tmp = array[hole];

        for (;hole * 2 <= currentSize; hole = child){
            child = hole * 2;

            // 条件child != currentSize是为了当数组有偶数个元素时
            // 没有右子节点情况的出现
            if(child != currentSize && array[child+1].compareTo(array[child]) < 0){
                child++;
            }
            if(array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            } else {
              break;
            }
        }

        array[hole] = tmp;
    }

    /**
     * 对任意结构的堆顺序进行排列
     * */
    private void buildHeap(){
        for (int i = currentSize/2; i > 0 ; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize){
        T[] oldArray = array;
        array = (T[]) new Object[newSize];

        for (int i = 1; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

}
