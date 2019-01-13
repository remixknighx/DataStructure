package com.interview;

/**
 * @author wangjf
 * @date 2019/1/13 0013.
 */
public class ThreadObject {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadObject2("thread1"));
        Thread thread2 = new Thread(new ThreadObject2("thread2"));
        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
        System.out.println("main method");
    }

}

class ThreadObject2 implements Runnable{

    private String name;

    public ThreadObject2(String name){
        this.name = name;
    }

    public void run() {
        System.out.println(this.name + " run");
    }

}
