package com.bill.sort;

/**
 * �����㷨�ĸ���ʵ��
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] array = {34,8,64,67,15,234,51,3,32,21};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /* ð������ start */
    /**
     * ð�������㷨
     *
     * @param array �����������
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
    /* ð������ end */

    /* ѡ������ start */
    /**
     * ѡ������
     *
     * @param array �����������
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
    /* ѡ������ end */

    /* �������� start */
    /**
     * ���������㷨��ʵ��
     *
     * @param array �����������
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
    /* �������� end */

    /**
     * ϣ�������㷨��ʵ��
     *
     * @param array �����������
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

    /* ʵ�ֶ�����Ĺ������������ڲ����� heapsort starts */
    /**
     * ������
     *
     * @param array �������array����
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
     * ���˲�������ɾ�����ֵ�Լ������
     *
     * @param array �����Ԫ��
     * @param i �ӽڵ�i����Ԫ�ؽ������˲���
     * @param n �ѵĳߴ�
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
     * ��λ��a��λ��b�ϵ�Ԫ�ؽ��н���
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
     * ��ȡһ���ڵ������ӵ�����ֵ
     *
     * @param i �ڵ������ֵ
     * @return �ýڵ�����ӵ�����ֵ
     * */
    private static int leftChild(int i){
        return 2 * i + 1;
    }
    /* ������ʵ�ֽ��� heapsort ends */

    /* �鲢���� starts */
    /**
     * �鲢����ĵ�һ��ʵ��
     *
     * @param array �����������
     * */
    public static <T extends Comparable<? super T>> void mergeSort(T[] array){
        T[] tmpArray = (T[]) new Comparable[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);
    }

    /**
     * �ڲ�����ʵ�ֵݹ����
     *
     * @param array ����������
     * @param tmpArray ��źϲ��������ʱ����
     * @param left ���������������ֵ
     * @param right ���������������ֵ
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
     * �ϲ������������������
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
    /* �鲢���� ends */

    /* �������� starts */

    /**
     * ���������㷨
     * */
    public static <T extends Comparable<? super T>> void quickSort(T[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * ����������ڲ�ʵ�ַ���
     *
     * @param array ����������
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
     * ��left��right��center����ֵ�������򣬲�����ŦԪ����right-1��
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
        
        // ����ŦԪ����right-1��
        swapReferences(array, center, right-1);
        return array[right-1];
    }
    /* �������� ends */
}
