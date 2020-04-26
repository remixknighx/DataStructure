package com.algorithm;

import java.util.Arrays;

/**
 * 优先级队列
 * <p>
 * 优先级队列不再遵循先入先出的原则，而是分为两种情况：
 * 最大优先级队列，无论入队顺序如何，都是当前最大的元素优先出队
 * 最小优先级队列，无论入队顺序如何，都是当前最小的元素优先出队
 * <p>
 * <p>
 * 最大堆的堆顶是整个堆中的最大元素
 * 最小堆的堆顶是整个堆中的最小元素
 * <p>
 * 因此可以用最大堆来实现最大优先级队列，最小堆来实现最小优先级队列
 * 每一次入队就是一个插入操作，时间复杂度为logn
 * 每一次出队就是一个删除操作，时间复杂度为logn
 */
public class BinaryHeapPriorityQueue {

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
        maxPQ.insert(12);
        maxPQ.insert(32);
        maxPQ.insert(24);
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());

    }

}

class MyPriorityQueue {


    /**
     * 定一个数组 用于存储数据
     */
    private int[] array;
    /**
     * 当前大小
     */
    private int size;

    public MyPriorityQueue() {
        //设定数组的初始值为32
        this.array = new int[32];
    }

    /**
     * 入队
     *
     * @param key
     */
    public void enQueue(int key) {

        //判断需不需要扩容
        if (size >= array.length) {
            //扩容
            resize();

        }

        //入队是一个插入操作，然后进行上浮调整
        array[size++] = key;
        upAdjust();
    }


    /**
     * 出队
     */
    public int dequeue() throws Exception {
        if (size <= 0) {
            throw new Exception("队列已空");
        }
        //获取堆顶元素
        int res = array[0];

        //删除堆顶元素，将最后一个元素移动到堆顶 同时大小减1
        array[0] = array[--size];
        downAdjust();
        return res;
    }


    /**
     * 下沉调整
     */
    public void downAdjust() {

        //对堆顶元素进行下沉操作
        //根节点值
        int temp = array[0];
        //当前父节点位置
        int parent = 0;
        int child = 2 * parent + 1;
        while (parent <= size) {

            //找到两个子树中大的那一个
            if (child + 1 < size && array[child] < array[child + 1]) {
                child++;
            }

            //如果没有比父节点更大的 就跳出循环    停止下沉
            if (temp >= array[child]) {
                break;
            }
            array[parent] = array[child];
            parent = child;
            child = 2 * parent + 1;
        }

        array[child] = temp;

    }

    /**
     * 数组扩容 2倍
     */
    private void resize() {
        array = Arrays.copyOf(array, 2 * size);
    }


    /**
     * 上浮
     */
    public void upAdjust() {
        //入队是一个插入操作，然后进行上浮调整

        //找到最后一个子树的位置
        int child = size - 1;

        //暂存其值
        int temp = array[child];

        //找到其父节点的位置
        int parent = (child - 1) / 2;


        //当子节点大于0，且父节点小于子节点的时候，持续上浮   大根堆
        while (child > 0 && temp > array[parent]) {
            array[child] = array[parent];
            //新的子节点
            child = parent;
            //新的父节点
            parent = (child - 1) / 2;
        }

        //直到找到一个父节点大于等于子节点的位置
        array[parent] = temp;
    }
}

class MaxPQ<K extends Comparable<K>> {
    /** 存储元素的数组 */
    private K[] pq;
    /** 当前Priority Queue中的元素个数 */
    private int n = 0;

    private static int DEFAULT_SIZE = 15;

    public MaxPQ() {
        this(DEFAULT_SIZE);
    }

    public MaxPQ(int cap) {
        pq = (K[]) new Comparable[cap+1];
    }

    public K max() {
        return pq[1];
    }

    public void insert(K e) {
        if (n >= pq.length) {
            resize();
        }
        // 先把新元素加到最后
        pq[++n] = e;
        // 然后让它上浮到正确的位置
        swim(n);
    }

    /**
     * 删除并返回当前队列中最大元素
     */
    public K delMax(){
        // 最大堆的堆顶就是最大元素
        K max = pq[1];
        // 把这个最大元素换到最后，删除之
        exch(1, n);
        pq[n--] = null;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素，以维护最大堆性质
     */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(parent(k), k)) {
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉第k个元素，以维护最大堆性质
     */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= n) {
            // 先假设左边节点较大
            int older = left(k);
            // 如果右边节点存在，比一下大小
            if (right(k) <= n && less(older, right(k))) {
                older = right(k);
            }
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k)) {
                break;
            }
            // 否则，不符合最大堆的结构，下沉 k 结点
            exch(k, older);
            k = older;
        }
    }

    /**
     * 交换数组的两个元素
     */
    private void exch(int i, int j) {
        K temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * pq[i]是否比pq[j]小
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /** 父节点的索引 */
    int parent(int root) {
        return root / 2;
    }

    /** 左孩子的索引 */
    int left(int root) {
        return root * 2;
    }

    /** 右孩子的索引 */
    int right(int root) {
        return root * 2 + 1;
    }

    /**
     * 数组扩容 2倍
     */
    private void resize() {
        pq = Arrays.copyOf(pq, 2 * n);
    }
}
