package com.bill.hash;

import java.util.LinkedList;
import java.util.List;

/**
 * ʹ�÷������ӷ�ʵ��һ��hash��
 */
public class SeparateChainHashTable<T> {

    /* private fields */
    private static final int DEFAULT_TABLE_SIZE = 101;

    private static final float loadFactor = 0.75f;

    private List<T>[] theLists;

    private int currentSize;

    /* public methods */
    /**
     * ����hash��
     * */
    public SeparateChainHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * ����hash��
     *
     * @param size ��Ԫ�ش�С
     * */
    public SeparateChainHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
    }

    /**
     * ��hash�����²���Ԫ��
     *
     * @param element ���������Ԫ��
     * */
    public void insert(T element){
        List<T> whichList = theLists[myhash(element)];

        if(whichList.size() == 0){
            currentSize++;
        }

        if(!whichList.contains(element)){
            whichList.add(element);

            // �������������Ԫ�صı�������װ�����ӵĴ�С�������½���hash����
            // ����������
            if((float)currentSize/theLists.length > loadFactor){
                rehash();
            }
        }
    }

    /**
     * ��hash����ɾ��Ԫ��
     *
     * @param element ���Ƴ���Ԫ��
     * */
    public void remove(T element){
        List<T> whichList = theLists[myhash(element)];
        if(whichList.contains(element)){
            whichList.remove(element);
        }

        if(whichList.size() == 0){
            currentSize--;
        }
    }

    /**
     * ����hash���е�Ԫ��
     *
     * @param element �����ҵ�Ԫ��
     * @return ����Ԫ���ڱ��д��ڣ��򷵻�true����֮��Ϊfalse
     * */
    public boolean contains(T element){
        List<T> whichList = theLists[myhash(element)];
        return whichList.contains(element);
    }

    /**
     * ���hash��
     * */
    public void makeEmpty(){
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = null;
        }
        currentSize = 0;
    }

    /**
     * ��ɢ��
     * */
    private void rehash(){
        List<T>[] oldLists = theLists;

        theLists = new List[nextPrime(2*theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }

        currentSize = 0;
        for (int i = 0; i < oldLists.length; i++) {
            for(T element: oldLists[i]){
                insert(element);
            }
        }
    }

    /* private static methods */
    /**
     * ����Ԫ�ص�hashֵ
     *
     * @param element ������Ԫ��
     * @return ����������hashֵ
     * */
    private int myhash(T element){

        int hashVal = element.hashCode();
        hashVal %= theLists.length;
        if(hashVal < 0){
            hashVal += theLists.length;
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
}
