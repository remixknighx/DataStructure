package com.bill.queue;

import java.util.NoSuchElementException;

/**
 * ʹ��˫������ʽʵ�ֵĶ���
 */
public class BillLinkedQueue<T> {

    private Node<T> firstNode;

    private Node<T> lastNode;

    public BillLinkedQueue(){}

    /**
     * ���
     */
    public void enqueue(T item){
        Node<T> l = lastNode;
        Node<T> newNode = new Node<T>(l, item, null);
        lastNode = newNode;
        if(l == null){
            firstNode = newNode;
        } else {
            l.next = newNode;
        }
    }

    /**
     * ����
     * */
    public T dequeue(){
        T item = firstNode.item;
        Node<T> next = firstNode.next;
        firstNode = next;
        if(next == null){
            lastNode = null;
        } else {
            next.prev = null;
        }

        return item;
    }

    private class Node<T>{
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T item, Node<T> next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
