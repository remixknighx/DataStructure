package com.bill.hash;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用分离链接法实现一个hash表
 */
public class SeparateChainHashTable<T> {

    /* private fields */
    private static final int DEFAULT_TABLE_SIZE = 101;

    private static final float loadFactor = 0.75f;

    private List<T>[] theLists;

    private int currentSize;

    /* public methods */
    /**
     * 创建hash表
     * */
    public SeparateChainHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * 创建hash表
     *
     * @param size 表元素大小
     * */
    public SeparateChainHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
    }

    /**
     * 向hash表中新插入元素
     *
     * @param element 待插入的新元素
     * */
    public void insert(T element){
        List<T> whichList = theLists[myhash(element)];

        if(whichList.size() == 0){
            currentSize++;
        }

        if(!whichList.contains(element)){
            whichList.add(element);

            // 若该数组中填充元素的比例超过装填因子的大小，则重新进行hash计算
            // 创建新数组
            if((float)currentSize/theLists.length > loadFactor){
                rehash();
            }
        }
    }

    /**
     * 从hash表中删除元素
     *
     * @param element 待移除的元素
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
     * 查找hash表中的元素
     *
     * @param element 待查找的元素
     * @return 若该元素在表中存在，则返回true，反之则为false
     * */
    public boolean contains(T element){
        List<T> whichList = theLists[myhash(element)];
        return whichList.contains(element);
    }

    /**
     * 清空hash表
     * */
    public void makeEmpty(){
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = null;
        }
        currentSize = 0;
    }

    /**
     * 再散列
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
     * 计算元素的hash值
     *
     * @param element 待计算元素
     * @return 经过计算后的hash值
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
     * 计算数字n之后的下一个素数
     *
     * @param n 需要输入的素数
     * @return 返回数字n之后的最小素数，若该数字原本就为素数，则直接返回
     *              否则依次计算大于n的最小素数
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
     * 判断数字n是否是素数
     *
     * @param n 待判断的数字n
     * @return 若为素数则为true，反之则为false
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
