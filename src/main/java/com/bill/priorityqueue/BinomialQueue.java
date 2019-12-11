package com.bill.priorityqueue;

/**
 * 二项队列的实现
 */
public class BinomialQueue<T extends Comparable<T>> {

    /* private field */
    private static final int DEFAULT_TREES = 1;

    private int currentSize;

    private Node<T>[] theTrees;

    /* public method */
    public BinomialQueue(){}

    public BinomialQueue(T element){}

    /**
     * 将rhs合并进优先队列中
     *
     * @param rhs 另一个二项队列
     * */
    public void merge(BinomialQueue<T> rhs){
        if(this == rhs){
            return;
        }

        currentSize += rhs.currentSize;

        if(currentSize > capacity()){
            int maxLength = Math.max(theTrees.length, rhs.theTrees.length);
            expandTheTrees(maxLength + 1);
        }

        Node<T> carry = null;
        for (int i = 0, j = 1; j <= currentSize ; i++, j*=2) {
            Node<T> t1 = theTrees[i];
            Node<T> t2 = (i < rhs.theTrees.length? rhs.theTrees[i]: null);

            int whichCase = (t1 == null? 0: 1);
            whichCase += (t2 == null? 0: 2);
            whichCase += (carry == null? 0: 4);

            switch (whichCase){
                case 0:
                case 1:
                    break;
                case 2:
                    theTrees[i] = t2;
                    rhs.theTrees[i] = t2;
                    break;
                case 4:
                    theTrees[i] = carry;
                    carry = null;
                    break;
                case 3:
                    carry = combineTrees(t1, t2);
                    theTrees[i] = rhs.theTrees[i] = null;
                    break;
                case 5:
                    carry = combineTrees(t1, carry);
                    theTrees[i] = null;
                    break;
                case 6:
                    carry = combineTrees(t2, carry);
                    rhs.theTrees[i] = carry;
                    break;
                case 7:
                    theTrees[i] = carry;
                    carry = combineTrees(t1, t2);
                    rhs.theTrees[i] = null;
                    break;
            }
        }

        for (int k = 0; k < rhs.theTrees.length; k++) {
            rhs.theTrees[k] = null;
        }
        rhs.currentSize = 0;
    }

    /**
     * 插入一棵新树
     *
     * @param element 待插入的树
     * */
    public void insert(T element){
        merge(new BinomialQueue<T>(element));
    }

    public T findMin(){
        return null;
    }

    public T deleteMin() throws Exception {
        if(isEmpty()){
            throw new Exception("二项队列为空");
        }

        int minIndex = findMinIndex();
        T minItem = theTrees[minIndex].element;

        Node<T> deletedTree = theTrees[minIndex].leftChild;

        BinomialQueue<T> deletedQueue = new BinomialQueue<T>();
        deletedQueue.expandTheTrees(minIndex + 1);

        deletedQueue.currentSize = (1<<minIndex) - 1;
        for (int j = minIndex-1; j >= 0; j--) {
            deletedQueue.theTrees[j] = deletedTree;
            deletedTree = deletedTree.nextSibling;
            deletedQueue.theTrees[j].nextSibling = null;
        }

        theTrees[minIndex] = null;
        currentSize -= deletedQueue.currentSize + 1;

        merge(deletedQueue);

        return minItem;
    }

    /**
     * 判断一个队列是否为空
     *
     * @return 若为空队列，则返回true，反之则为false
     * */
    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void makeEmpty(){
        currentSize = 0;
    }

    /* private method */
    private void expandTheTrees(int maxLength){}

    private int findMinIndex(){
        return 1;
    }

    /**
     * 将两棵具有相同尺寸大小的树进行合并
     * 树1的元素大小要小于树2
     *
     * @param t1 树1
     * @param t2 树2
     * @return 返回合并后的树
     * */
    private Node<T> combineTrees(Node<T> t1, Node<T> t2){
        if(t1.element.compareTo(t2.element) > 0){
            return combineTrees(t2, t1);
        }
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    /**
     * 树的容量大小
     *
     * @return 返回树新增的容量大小
     * */
    private int capacity(){
        return (1 << theTrees.length) - 1;
    }

    /* private class */
    private static class Node<T>{

        T element;
        Node<T> leftChild;
        Node<T> nextSibling;

        Node(T element){
            this(element, null, null);
        }

        Node(T element, Node<T> leftChild, Node<T> nextSibling){
            this.element = element;
            this.leftChild = leftChild;
            this.nextSibling = nextSibling;
        }
    }
}
