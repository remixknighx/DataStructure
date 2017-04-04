package com.bill.tree;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(T element){
        return contains(element, root);
    }

    private boolean contains(T element, BinaryNode<T> root){
        if(root == null){
            return false;
        }

        int compareResult = element.compareTo(root.element);

        if(compareResult < 0){
            return contains(element, root.left);
        } else if(compareResult > 0) {
            return contains(element, root.right);
        } else {
            return true;
        }
    }

    public T findMin(){
        if(isEmpty()){
            return null;
        }
        return findMin(root).element;
    }

    public BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.left == null){
            return node;
        }
        return findMin(node.left);
    }

    public T findMax(){
        if(isEmpty()){
            return null;
        }
        return findMax(root).element;
    }

    public BinaryNode<T> findMax(BinaryNode<T> node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public void insert(T element){
        root = insert(element, root);
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> root){
        if(root == null){
            return new BinaryNode<T>(element, null, null);
        }

        int compareResult = element.compareTo(root.element);

        if (compareResult < 0) {
            root.left = insert(element, root.left);
        } else if (compareResult > 0){
            root.right = insert(element, root.right);
        }
//        重复项插入时，不做任何操作
        return root;
    }

    public void remove(T element){
        root = remove(element, root);
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> root){
        if(root == null){
            return root;
        }

        int compareResult = element.compareTo(root.element);

        if(compareResult < 0){
            root.left = remove(element, root.left);
        } else if(compareResult > 0) {
            root.right = remove(element, root.right);
        } else if(root.left != null && root.right != null){
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }

        return root;
    }

    public void printTree(){
        if(isEmpty()){
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    /**
     * 使用中序遍历打印树中所有元素的名字
     * */
    private void printTree(BinaryNode<T> root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }
    /**
     * 构造的节点类型
     * */
    private static class BinaryNode<T>{

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element){
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

}
