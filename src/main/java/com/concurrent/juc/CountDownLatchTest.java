package com.concurrent.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(5);
        CountDownLatch doneSignal = new CountDownLatch(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1));

        for (int i = 0; i < 5; i++) {
            executor.submit(new Worker(i, startSignal, doneSignal));
            startSignal.countDown();
        }

        System.out.println(Thread.currentThread().getName() + " wait for the signal");
        doneSignal.await();
        executor.shutdown();
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
            System.out.println(Thread.currentThread().getName() + " Work: " + workNum);
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
