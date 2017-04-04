package com.bill.tree;

/**
 * 左子树和右子树最多差1的二叉查找树
 */
public class AVLTree<T extends Comparable<T>>{

    private AvlNode<T> root;

    private int height(AvlNode<T> node){
        return node == null ? -1 : node.height;
    }

    public void insert(T element){
        root = insert(element, root);
    }

    private AvlNode<T> insert(T element, AvlNode<T> root){
        if(root == null){
            return new AvlNode<T>(element, null, null);
        }

        int compareResult = element.compareTo(root.element);

        if(compareResult < 0){
            root.left = insert(element, root.left);
            if(height(root.left) - height(root.right) == 2) {
                if (element.compareTo(root.left.element) < 0) {
                    rotateWithLeftChild(root);
                } else {
                    doubleWithLeftChild(root);
                }
            }
        }
        else if(compareResult > 0){
            root.right = insert(element, root.right);

            if(height(root.right) - height(root.left) == 2) {
                if (element.compareTo(root.right.element) > 0) {
                    rotateWithRightChild(root);
                } else {
                    doubleWithRightChild(root);
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right))+1;
        return root;
    }

    /**
     * 单旋转，对左儿子的左子树进行旋转
     * */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
        AvlNode<T> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        node.height = Math.max(height(node.left), height(node.right))+1;
        newNode.height = Math.max(height(newNode.left), node.height)+1;
        return newNode;
    }

    /**
     * 单旋转，对右儿子的右子树进行旋转
     * */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> node){
        AvlNode<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        node.height = Math.max(height(node.left), height(node.right))+1;
        newNode.height = Math.max(height(newNode.right), node.height)+1;
        return newNode;
    }

    /**
     * 双旋转，对左儿子的右子树进行旋转
     * */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    /**
     * 双旋转，对右儿子的左子树进行旋转
     * */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    private static class AvlNode<T>{

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height = 0;

        AvlNode(T element){
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> left, AvlNode<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

}
