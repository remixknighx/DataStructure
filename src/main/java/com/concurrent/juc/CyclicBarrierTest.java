package com.concurrent.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjianfeng
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(3), new ThreadFactoryBuilder().setNameFormat("cyclic-barrier-").build());
        executor.submit(new CyclicWorker(cyclicBarrier, "Harry"));
        Thread.sleep(2000);
        executor.submit(new CyclicWorker(cyclicBarrier, "Hermin"));
        Thread.sleep(2000);
        executor.submit(new CyclicWorker(cyclicBarrier, "Ronney"));

        executor.shutdown();
    }

}

class CyclicWorker implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String workerName;

    public CyclicWorker(CyclicBarrier cyclicBarrier, String workerName){
        this.cyclicBarrier = cyclicBarrier;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("CyclicWorkerName is " + workerName);

    }
}
