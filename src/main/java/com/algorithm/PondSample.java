package com.algorithm;

import java.util.Random;

/**
 * 水塘抽样算法
 * 给你一个未知长度的链表，请你设计一个算法，只能遍历一次，随机地返回链表中的一个节点。
 *
 * @author wangjianfeng
 */
public class PondSample {

    public static void main(String[] args) {

    }

    /* 返回链表中 k 个随机节点的值 */
    private static int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int j = 0; j < k && p != null; j++) {
            res[j] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(++i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }

}
