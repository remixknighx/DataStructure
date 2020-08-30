package com.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangjf
 * @date 2019/1/20 0020.
 */
public class TreeLevelOrder {

    public static void main(String[] args) {
        Node five = new Node(5, null);
        Node six = new Node(6, null);
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(0, five);
        nodes.add(1, six);

        Node three = new Node(3, nodes);
        Node two = new Node(2, null);
        Node four = new Node(4, null);
        List<Node> nodes2 = new ArrayList<Node>();
        nodes2.add(0, three);
        nodes2.add(1, two);
        nodes2.add(2, four);

        Node one = new Node(1, nodes2);

        List<List<Integer>> result = new TreeLevelOrder().levelOrder(one);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.children != null && tmp.children.size() != 0) {
                    for (Node node : tmp.children) {
                        if (node != null) {
                            queue.offer(node);
                        }
                    }
                }
            }
            result.add(list);
        }

        return result;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
