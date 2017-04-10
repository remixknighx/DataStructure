package com.bill.priorityqueue;

/**
 * ��ʽ�ѵ�ʵ��
 */
public class LeftistHeap<T extends Comparable<T>> {
    /* private field */
    /**
     * ��ʽ�ѵĸ��ڵ�
     * */
    private Node<T> root;

    /* public method */
    public LeftistHeap(){}

    /**
     * ����ʽ��rhs�ϲ������ȶ����У�rhs��Ϊ��
     * rhs�ѱ�����ԭ�Ѳ�ͬ
     *
     * @param rhs ��Ҫ�ϲ�����ʽ��
     * */
    public void merge(LeftistHeap<T> rhs){
        if(this == rhs){
            return;
        }

        root = merge(root, rhs.root);
        rhs.root = null;
    }

    /**
     * ������Ԫ��
     *
     * @param element �������Ԫ��
     * */
    public void insert(T element){
        root = merge(new Node<T>(element), root);
    }

    /**
     * ���ض����е���СԪ��
     *
     * @return minItem
     * */
    public T deleteMin(){
        if(isEmpty()){
            throw new NullPointerException("�ö����в�����Ԫ��");
        }
        T minItem = root.element;
        root = merge(root.left, root.right);

        return minItem;
    }

    /**
     * �ж���ʽ���Ƿ�Ϊ��
     *
     * @return �����ʽ��Ϊ�գ��򷵻�true����֮��Ϊfalse
     * */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * �����ʽ����Ԫ�ص�����
     * */
    public void makeEmpty(){
        root = null;
    }

    /* private method */
    /**
     * �ϲ������ѵ��ڲ����������õݹ�ķ���
     *
     * @param h1
     * @param h2
     * @return �ϲ�����¶�
     * */
    private Node<T> merge(Node<T> h1, Node<T> h2){
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }
        if(h1.element.compareTo(h2.element) < 0){
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }

    /**
     * �ϲ������ǿնѣ����Ҹ��ڵ�h1��Ԫ��С�ڸ��ڵ�h2��Ԫ��
     *
     * @param h1
     * @param h2
     * @return �ϲ���Ķ�
     * */
    private Node<T> merge1(Node<T> h1, Node<T> h2){
        if(h1.left == null){
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if(h1.left.npl < h1.right.npl){
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    /**
     * �����ýڵ����������ӽڵ��λ��
     *
     * @param t ��Ҫ���н����Ľڵ�
     * */
    private void swapChildren(Node<T> t){
        Node<T> tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }

    /* private class */
    private static class Node<T>{

        T element;
        Node<T> left;
        Node<T> right;

        // ��·����(null path length, npl)
        int npl;

        Node(T element){
            this(element, null, null);
        }

        Node(T element, Node<T> left, Node<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
            npl = 0;
        }
    }
}
