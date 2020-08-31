package com.leetcode;

import com.leetcode.easy.RemoveDuplicatesFromSortedList;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangjf
 * @date 2017/7/12.
 */
public class RemoveDuplicatesFromSortedListTest {

    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList;

    @Before
    public void setUp() throws Exception {
        removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
    }

    @Test
    public void testDeleteDuplicates() throws Exception {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(3);

    }

}