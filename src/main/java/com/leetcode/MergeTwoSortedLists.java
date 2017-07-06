package com.leetcode;

/**
 * 21. Merget Two Sorted Lists
 * @link https://leetcode.com/problems/merge-two-sorted-lists/#/description
 *
 * @author wangjf
 * @date 2017/7/5.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listOneFirst = new ListNode(4);
        ListNode listOneSecond = new ListNode(5);
        listOneFirst.setNext(listOneSecond);

        ListNode listTwoFirst = new ListNode(1);
        ListNode listTwoSecond = new ListNode(2);
        listTwoFirst.setNext(listTwoSecond);
        ListNode listTwoThird = new ListNode(3);
        listTwoSecond.setNext(listTwoThird);
        ListNode listTwoFourth = new ListNode(4);
        listTwoThird.setNext(listTwoFourth);

        new MergeTwoSortedLists().mergeTwoLists(listOneFirst, listTwoFirst);
    }

    public ListNode mergeTwoLists(ListNode nodeOne, ListNode nodeTwo) {

        if (nodeOne == null && nodeTwo == null) {
            return null;
        } else if (nodeOne == null) {
            return nodeTwo;
        } else if (nodeTwo == null) {
            return  nodeOne;
        }

        ListNode lastNode = new ListNode();
        ListNode resultList = lastNode;

        while (nodeOne != null && nodeTwo != null) {
            lastNode.setValue(nodeOne.getValue() + nodeTwo.getValue());
            lastNode.setNext(new ListNode());
            lastNode = lastNode.getNext();

            nodeOne = nodeOne.getNext();
            nodeTwo = nodeTwo.getNext();
        }

        if (nodeOne != null) {
            lastNode.setValue(nodeOne.getValue());
            lastNode.setNext(nodeOne.getNext());
        }

        if (nodeTwo != null) {
            lastNode.setValue(nodeTwo.getValue());
            lastNode.setNext(nodeTwo.getNext());
        }

        return resultList;
    }

    /**
     * ÄÚ²¿Àà
     */
    static class ListNode {
        int value;

        ListNode next;

        ListNode(){}

        ListNode(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
