package com.concurrent.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(5);
        CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(i, startSignal, doneSignal)).start();
            startSignal.countDown();
        }

        System.out.println("wait for the signal");
        doneSignal.await();
        System.out.println("game end");
    }

}

class Worker implements Runnable{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private int workNum;

    Worker(int workNum, CountDownLatch startSignal, CountDownLatch doneSignal){
        this.workNum = workNum;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            System.out.println("Work: " + workNum);
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
