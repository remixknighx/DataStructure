package com.bill.sort;

/**
 * 排序算法的各种实现
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] array = {34,8,64,67,15,234,51,3,32,21};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /* 冒泡排序 start */
    /**
     * 冒泡排序算法
     *
     * @param array 待排序的数组
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    /* 冒泡排序 end */

    /* 选择排序 start */
    /**
     * 选择排序
     *
     * @param array 待排序的数组
     */
    public static <T extends Comparable<? super T>> void selectSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                T temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

        }
    }
    /* 选择排序 end */

    /* 插入排序 start */
    /**
     * 插入排序算法的实现
     *
     * @param array 待排序的数组
     * */
    public static <T extends Comparable<? super T>> void insertSort(T[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    /* 插入排序 end */

    /**
     * 希尔排序算法的实现
     *
     * @param array 待排序的数组
     * */
    public static <T extends Comparable<? super T>> void shellSort(T[] array){
        for(int gap = array.length/2; gap > 0; gap /= 2){
           for (int i = gap; i < array.length; i += gap) {
                for(int j = 0; j < i; j += gap){
                    if(array[i].compareTo(array[j]) < 0){
                        T tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
           }
       }
    }

    /* 实现堆排序的公共方法及其内部方法 heapsort starts */
    /**
     * 堆排序
     *
     * @param array 待排序的array数组
     * */
    public static <T extends Comparable<? super T>> void heapSort(T[] array){
        for(int i = array.length/2; i >= 0; i--){
            percDown(array, i, array.length);
        }

        for (int i = array.length-1; i > 0; i--) {
            swapReferences(array, 0, i);
            percDown(array, 0, i);
        }
    }

    /**
     * 下滤操作用来删除最大值以及构造堆
     *
     * @param array 数组堆元素
     * @param i 从节点i处的元素进行下滤操作
     * @param n 堆的尺寸
     * */
    private static <T extends Comparable<? super T>> void percDown(T[] array, int i, int n){
        int child;
        T tmp;

        for(tmp = array[i]; leftChild(i) < n; i = child){
            child = leftChild(i);
            if(child != n-1 && array[child].compareTo(array[child+1]) < 0){
                child++;
            }
            if(tmp.compareTo(array[child]) < 0){
                array[i] = array[child];
            }
            else
                break;
        }
        array[i] = tmp;
    }

    /**
     * 将位置a与位置b上的元素进行交换
     *
     * @param array
     * @param a
     * @param b
     * */
    private static <T extends Comparable<? super T>> void swapReferences(T[] array, int a, int b){
        if (a == b) {
            return;
        }

        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /**
     * 获取一个节点的左儿子的索引值
     *
     * @param i 节点的索引值
     * @return 该节点左儿子的索引值
     * */
    private static int leftChild(int i){
        return 2 * i + 1;
    }
    /* 堆排序实现结束 heapsort ends */

    /* 归并排序 starts */
    /**
     * 归并排序的第一种实现
     *
     * @param array 待排序的数组
     * */
    public static <T extends Comparable<? super T>> void mergeSort(T[] array){
        T[] tmpArray = (T[]) new Comparable[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);
    }

    /**
     * 内部方法实现递归调用
     *
     * @param array 待排序数组
     * @param tmpArray 存放合并结果的临时数组
     * @param left 子数组的最左索引值
     * @param right 子数组的最右索引值
     * */
    private static <T extends Comparable<? super T>> void mergeSort(T[] array, T[] tmpArray, int left, int right){
        if(left < right){
            int center = (left+right)/2;
            mergeSort(array, tmpArray, left, center);
            mergeSort(array, tmpArray, center+1, right);
            merge(array, tmpArray, left, center+1, right);
        }
    }

    /**
     * 合并两组已排序的子数组
     * */
    private static <T extends Comparable<? super T>> void merge(T[] array, T[] tmpArray, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;

        while(leftPos <= leftEnd && rightPos <= rightEnd){
            if(array[leftPos].compareTo(array[rightPos]) <= 0){
                tmpArray[tmpPos++] = array[leftPos++];
            }
            else{
                tmpArray[tmpPos++] = array[rightPos++];
            }
        }

        while(leftPos <= leftEnd){
            tmpArray[tmpPos++] = array[leftPos++];
        }

        while(rightPos <= rightEnd){
            tmpArray[tmpPos++] = array[rightPos++];
        }

        //Copy tmpArray back
        for (int i = 0; i <= rightEnd; i++) {
            array[i] = tmpArray[i];
        }
    }
    /* 归并排序 ends */

    /* 快速排序 starts */

    /**
     * 快速排序算法
     * */
    public static <T extends Comparable<? super T>> void quickSort(T[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序的内部实现方法
     *
     * @param array 待排序数组
     * @param left
     * @param right
     * */
    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right){
        T pivot = median3(array, left, right);

        int i = left;
        int j = right - 1;

        while (true){
            while (array[++i].compareTo(pivot) < 0){}
            while (array[--j].compareTo(pivot) > 0){}
            if(i < j) {
                swapReferences(array, i, j);
            } else {
                break;
            }
        }

        swapReferences(array, i, right-1);
        quickSort(array, left, i-1);
        quickSort(array, i+1, right);
    }

    /**
     * 将left，right，center三个值进行排序，并将枢纽元放在right-1处
     * */
    private static <T extends Comparable<? super T>> T median3(T[] array, int left, int right){
        int center = (left+right) / 2;

        if(array[center].compareTo(array[left]) < 0){
            swapReferences(array, left, center);
        }
        if(array[right].compareTo(array[left]) < 0){
            swapReferences(array, left, right);
        }
        if(array[right].compareTo(array[center]) < 0){
            swapReferences(array, right, center);
        }
        
        // 将枢纽元放在right-1处
        swapReferences(array, center, right-1);
        return array[right-1];
    }
    /* 快速排序 ends */
}
