package com.bill.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class BillArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private T[] items;

    public BillArrayList(){
        clear();
    }

    public T get(){
        return get(size - 1);
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("该索引值不符合要求");
        }

        return items[index];
    }

    public T set(int index, T newVal){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("该索引值不符合要求");
        }

        T old = items[index];
        items[index] = newVal;
        return old;
    }

    public boolean add(T newItem){
        add(size, newItem);
        return true;
    }

    public void add(int index, T newItem){
        if(items.length == size){
            ensureCapacity(size*2+1);
        }

        for(int i = size; i > index; i--){
            items[i] = items[i-1];
        }

        items[index] = newItem;

        size++;
    }

    public T remove(int index){
        T removedItem = items[index];

        for(int i = index; i < size - 1; i++){
            items[i] = items[i+1];
        }

        size--;

        return removedItem;
    }

    public void clear(){
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void trimToSize(){
        ensureCapacity(size);
    }

    /**
     * 创建一个新的大容量数组，并将老数组中的值复制到新数组中
     *
     * @param newCapacity
     * */
    public void ensureCapacity(int newCapacity){
       if(newCapacity < size){
           return;
       }
       T[] old = items;
       items = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            items[i] = old[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>();
    }

    private class ArrayListIterator<T> implements Iterator<T> {

        private int current = 0;

        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (T) items[current++];
        }

        @Override
        public void remove() {
            BillArrayList.this.remove(--current);
        }
    }
}
