package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjf
 * @date 2017/7/17 0017.
 */
public class IntersectionOf2ListsTest {

    IntersectionOf2Lists intersectionList;

    @Before
    public void setUp() throws Exception {
        intersectionList = new IntersectionOf2Lists();
    }

    @Test
    public void getIntersectionNode() throws Exception {
        ListNode head3 = new ListNode(6);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(8);
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = head3;
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = head3;
        assertEquals(head3, intersectionList.getIntersectionNode(head1, head2));

        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        ListNode head5 = new ListNode(4);
        head5.next = new ListNode(5);
        assertEquals(null, intersectionList.getIntersectionNode(head4, head5));
    }

}