package com.bill.hash;

/**
 * ����̽�ⷨ����һ��hash��
 *
 * @author Administrator
 */
public class QuadraticProbingHashTable<T> {

    /* private fields */
    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<T>[] array;

    private int currentSize;

    /* public methods */
    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int currentSize) {
        this.currentSize = currentSize;
        allocateArray(this.currentSize);
        makeEmpty();
    }

    /**
     * ���hash��
     * */
    public void makeEmpty(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }

        currentSize = 0;
    }

    /**
     * ����hash���е�Ԫ��
     *
     * @param element �����ҵ�Ԫ��
     * @return ����Ԫ���ڱ��д��ڣ��򷵻�true����֮��Ϊfalse
     * */
    public boolean contains(T element){
        int currentPos = findPos(element);
        return isActive(currentPos);
    }

    /**
     * ������Ԫ���в�����Ԫ��
     *
     * @param element �������Ԫ��
     * */
    public void insert(T element){
        int currentPos = findPos(element);

        if(isActive(currentPos)){
            return;
        }

        array[currentPos] = new HashEntry<T>(element);

        if(++currentSize > array.length/2){
            rehash();
        }
    }

    /**
     * ��������ɾ����Ԫ��(���ý���Ԫ�ص�isActive���Ϊfalse�ķ�ʽ)
     *
     * @param element ��ɾ����Ԫ��
     * */
    public void remove(T element){
        int currentPos = findPos(element);
        if(isActive(currentPos)){
            array[currentPos].isActive = false;
        }
    }

    /**/

    /* private static methods */
    /**
     * ��������Ԫ�ش�С
     *
     * @param arraySize �����С
     * */
    private void allocateArray(int arraySize){
        array = new HashEntry[arraySize];
    }

    /**
     * �ж�һ��Ԫ���Ƿ����
     *
     * @param currentPos ����Ѱ������Ԫ��
     * @return ����Ԫ�ز�Ϊ����isActive״̬Ϊtrue���򷵻�true
     * */
    private boolean isActive(int currentPos){
        return (array[currentPos]!=null) && array[currentPos].isActive;
    }

    /**
     * ����ָ���Ԫ�ص�ָ��
     *
     * @param element �����ҵ�Ԫ��
     * @return Ԫ������λ�õ�ָ��
     * */
    private int findPos(T element){
        int offset = 1;
        int currentPos = myhash(element);

        while(array[currentPos] != null && !array[currentPos].element.equals(element)){
            currentPos += offset;
            offset+=2;

            if(currentPos >= array.length){
                currentPos -= array.length;
            }
        }

        return currentPos;
    }

    /**
     * ������Ԫ�صĴ�С�ﵽһ��ֵʱ�����½���ɢ�м���
     * */
    private void rehash(){
        HashEntry<T>[] oldArray = array;

        // ���array�����е�����
        makeEmpty();

        // ���·��������С
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        //���������е�ֵ���Ƶ���������
        for (int i = 0; i < oldArray.length; i++) {
            if(oldArray[i] != null && oldArray[i].isActive){
                insert(oldArray[i].element);
            }
        }
    }

    /**
     * ����Ԫ�ص�hashֵ
     *
     * @param element ������Ԫ��
     * @return ����������hashֵ
     * */
    private int myhash(T element){

        int hashVal = element.hashCode();
        hashVal %= array.length;
        if(hashVal < 0){
            hashVal += array.length;
        }

        return hashVal;
    }

    /**
     * ��������n֮�����һ������
     *
     * @param n ��Ҫ���������
     * @return ��������n֮�����С��������������ԭ����Ϊ��������ֱ�ӷ���
     *              �������μ������n����С����
     * */
    private static int nextPrime(int n){
        if(isPrime(n)){
            return n;
        }

        while (true){
            n += 1;
            if(isPrime(n)){
                return n;
            }
        }
    }

    /**
     * �ж�����n�Ƿ�������
     *
     * @param n ���жϵ�����n
     * @return ��Ϊ������Ϊtrue����֮��Ϊfalse
     * */
    private static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    /* ��Ԫ�ڵ� */
    private static class HashEntry<T>{
        public T element;

        //����Ԫ���ѱ�ɾ��������Ϊfalse
        public boolean isActive;

        public HashEntry(T element){
            this(element, true);
        }

        public HashEntry(T element, boolean isActive){
            this.element = element;
            this.isActive = isActive;
        }
    }

}
