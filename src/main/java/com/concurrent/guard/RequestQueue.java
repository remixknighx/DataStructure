package com.concurrent.guard;

import java.util.LinkedList;

/**
 * RequestQueue对象作为Request的集合，维护系统的Request请求列表
 *
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class RequestQueue {

    private LinkedList<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest(){
        while (queue.size() == 0){
            try {
                wait();                     // 直到有新的Request对象
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.removeFirst();             // 返回request队列中的第一个请求
    }

    public synchronized void addRequest(Request request){
        queue.addLast(request);
        notifyAll();
    }

}
