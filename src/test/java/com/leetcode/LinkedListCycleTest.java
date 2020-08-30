package com.leetcode;

import com.leetcode.easy.LinkedListCycle;
import com.leetcode.easy.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class LinkedListCycleTest {

    LinkedListCycle cycle;

    @Before
    public void setUp() throws Exception {
        cycle = new LinkedListCycle();
    }

    @Test
    public void hasCycle() throws Exception {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = list;
        assertTrue(cycle.hasCycle(list));

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        assertFalse(cycle.hasCycle(list2));
    }

}