package com.bill.priorityqueue;

import java.util.Comparator;

/**
 * ����ѣ�<b>�ṹ��</b>��<b>������</b>
 * ����ʹ������ķ�ʽʵ�ֶ���ѽṹ
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    /* private field */
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

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
     * �������ȶ����У����ֶ�Ԫ�ص�˳��
     *
     * @param element ������Ķ�Ԫ��
     * */
    public void insert(T element){
        if(currentSize == array.length-1){
            enlargeArray(array.length * 2 + 1);
        }

        //����
        int hole = ++currentSize;
        while ((hole > 1) && (element.compareTo(array[hole / 2]) < 0)){
            array[hole] = array[hole/2];
            hole /= 2;
        }

        array[hole] = element;
    }

    /**
     * �������ȶ����е���Сֵ
     *
     * @return ���ȶ��ж��е���Сֵ
     * */
    public T deleteMin(){
        if(isEmpty()){
            throw new NullPointerException();
        }

        T minItem = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void makeEmpty(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /* private method */
    /**
     * ���˲���
     *
     * @param hole
     * */
    private void percolateDown(int hole){
        int child;
        T tmp = array[hole];

        for (;hole * 2 <= currentSize; hole=child){
            child = hole * 2;
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
     * ������ṹ�Ķ�˳���������
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
