package com.bill.stack;

import com.bill.list.BillArrayList;
import com.bill.queue.BillArrayQueue;
import com.bill.queue.BillLinkedQueue;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class Test {

    public static void main(String[] args) {
        BillArrayQueue<String> myQueue = new BillArrayQueue<String>();
        myQueue.enqueue("1");
        myQueue.enqueue("2");
        myQueue.enqueue("3");
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
