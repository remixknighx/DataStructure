package com.bill.hash;

/**
 * 利用探测法创建一个hash表
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
     * 清空hash表
     * */
    public void makeEmpty(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }

        currentSize = 0;
    }

    /**
     * 查找hash表中的元素
     *
     * @param element 待查找的元素
     * @return 若该元素在表中存在，则返回true，反之则为false
     * */
    public boolean contains(T element){
        int currentPos = findPos(element);
        return isActive(currentPos);
    }

    /**
     * 向数组元素中插入新元素
     *
     * @param element 待插入的元素
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
     * 向数组中删除旧元素(采用将该元素的isActive标记为false的方式)
     *
     * @param element 待删除的元素
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
     * 分配数组元素大小
     *
     * @param arraySize 数组大小
     * */
    private void allocateArray(int arraySize){
        array = new HashEntry[arraySize];
    }

    /**
     * 判断一个元素是否可用
     *
     * @param currentPos 待搜寻的数组元素
     * @return 若该元素不为空且isActive状态为true，则返回true
     * */
    private boolean isActive(int currentPos){
        return (array[currentPos]!=null) && array[currentPos].isActive;
    }

    /**
     * 查找指向该元素的指针
     *
     * @param element 待查找的元素
     * @return 元素所在位置的指针
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
     * 当数组元素的大小达到一定值时，重新进行散列计算
     * */
    private void rehash(){
        HashEntry<T>[] oldArray = array;

        // 清空array数组中的内容
        makeEmpty();

        // 重新分配数组大小
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        //将老数组中的值复制到新数组中
        for (int i = 0; i < oldArray.length; i++) {
            if(oldArray[i] != null && oldArray[i].isActive){
                insert(oldArray[i].element);
            }
        }
    }

    /**
     * 计算元素的hash值
     *
     * @param element 待计算元素
     * @return 经过计算后的hash值
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

    /* 单元节点 */
    private static class HashEntry<T>{
        public T element;

        //若该元素已被删除，则标记为false
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
