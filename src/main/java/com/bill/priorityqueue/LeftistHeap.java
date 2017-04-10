package com.bill.priorityqueue;

/**
 * 左式堆的实现
 */
public class LeftistHeap<T extends Comparable<T>> {
    /* private field */
    /**
     * 左式堆的根节点
     * */
    private Node<T> root;

    /* public method */
    public LeftistHeap(){}

    /**
     * 将左式堆rhs合并至优先队列中，rhs变为空
     * rhs堆必须与原堆不同
     *
     * @param rhs 需要合并的左式堆
     * */
    public void merge(LeftistHeap<T> rhs){
        if(this == rhs){
            return;
        }

        root = merge(root, rhs.root);
        rhs.root = null;
    }

    /**
     * 插入新元素
     *
     * @param element 待插入的元素
     * */
    public void insert(T element){
        root = merge(new Node<T>(element), root);
    }

    /**
     * 返回队列中的最小元素
     *
     * @return minItem
     * */
    public T deleteMin(){
        if(isEmpty()){
            throw new NullPointerException("该队列中不存在元素");
        }
        T minItem = root.element;
        root = merge(root.left, root.right);

        return minItem;
    }

    /**
     * 判断左式堆是否为空
     *
     * @return 如果左式堆为空，则返回true，反之则为false
     * */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 清空左式堆中元素的内容
     * */
    public void makeEmpty(){
        root = null;
    }

    /* private method */
    /**
     * 合并两个堆的内部方法，采用递归的方法
     *
     * @param h1
     * @param h2
     * @return 合并后的新堆
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
     * 合并两个非空堆，并且根节点h1的元素小于根节点h2的元素
     *
     * @param h1
     * @param h2
     * @return 合并后的堆
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
     * 交换该节点左右两个子节点的位置
     *
     * @param t 需要进行交换的节点
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

        // 零路径长(null path length, npl)
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
