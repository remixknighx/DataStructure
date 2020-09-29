package com.leetcode.medium;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [148] Sort List
 *
 * @link https://leetcode.com/problems/sort-list/description/
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sortedList = new SortList().sortList(head);
        System.out.println(sortedList);
    }

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode headIdx = head;
        while (headIdx != null) {
            list.add(headIdx.val);
            headIdx = headIdx.next;
        }

        List<Integer> sortedKey = list.stream().sorted().collect(Collectors.toList());
        ListNode result = new ListNode();
        ListNode resultIdx = result;
        for (int num: sortedKey) {
            resultIdx.next = new ListNode(num);
            resultIdx = resultIdx.next;
        }

        return result.next;
    }

}
