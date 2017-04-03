package com.bill.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class BillLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public BillLinkedList(){
        clear();
    }

    public T get(int index){
        return getNode(index).item;
    }

    public T set(int index, T newItem){
        Node<T> node = getNode(index);
        T oldItem = node.item;
        node.item = newItem;

        return oldItem;
    }

    public <T> void remove(int index){
        remove(getNode(index));
    }


    private <T> void remove(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size --;
        modCount --;
    }

    public boolean add(T newItem){
        add(size, newItem);
        return true;
    }

    public void add(int index, T newItem){
        addBefore(getNode(index), newItem);
    }

    private Node<T> getNode(int index){
        Node<T> p;

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("该" + index + "索引值不存在");
        }

        if(index < size/2){
            p = beginMarker;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size; i > index; i--){
                p = p.prev;
            }
        }

        return p;
    }

    private void addBefore(Node<T> node, T newItem){
        Node<T> newNode = new Node<T>(newItem, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        size++;
        modCount++;
    }

    public void clear(){
        beginMarker = new Node<T>(null, null, endMarker);
        endMarker = new Node<T>(null, beginMarker, null);
        size = 0;
        modCount = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        Node<T> current = (Node<T>) beginMarker;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public LinkedListIterator(){}

        public boolean hasNext(){
            return current != endMarker;
        }

        public T next(){
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T nextItem = current.item;
            current = current.next;
            okToRemove = true;

            return nextItem;
        }

        public void remove(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }

            BillLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }

        public Iterator<T> iterator() {
            return null;
        }
    }

    private static class Node<T>{
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(T item, Node<T> prev, Node<T> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
