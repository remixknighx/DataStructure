package com.concurrent.juc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore threadPool = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            threadPool.acquire();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Number is " + i);
            threadPool.release();
        }
    }

}
