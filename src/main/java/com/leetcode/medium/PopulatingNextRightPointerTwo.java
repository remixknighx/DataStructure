package com.leetcode.medium;

import com.leetcode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [117] Populating Next Right Pointers in Each Node II
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */
public class PopulatingNextRightPointerTwo {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            Node head = nodeList.remove(0);
            if (head == null) {
                break;
            }

            if (nodeList.isEmpty()) {
                head.next = null;
                if (head.left != null) {
                    nodeList.add(head.left);
                }
                if (head.right != null) {
                    nodeList.add(head.right);
                }
            } else {
                List<Node> tempList = new ArrayList<>();
                if (head.left != null) {
                    tempList.add(head.left);
                }
                if (head.right != null) {
                    tempList.add(head.right);
                }
                while (!nodeList.isEmpty()) {
                    Node secondNode = nodeList.remove(0);
                    head.next = secondNode;
                    head = head.next;
                    if (secondNode.left != null) {
                        tempList.add(secondNode.left);
                    }
                    if (secondNode.right != null) {
                        tempList.add(secondNode.right);
                    }
                }
                head.next = null;
                nodeList.addAll(new ArrayList<>(tempList));
            }
        }

        return root;
    }

}
