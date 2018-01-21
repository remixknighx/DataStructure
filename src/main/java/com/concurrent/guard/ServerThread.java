package com.concurrent.guard;

/**
 * 服务端进程的代码如下，用于处理用户的请求操作
 *
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class ServerThread extends Thread{

    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run(){
        while (true){
            Request request = requestQueue.getRequest();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }

}
