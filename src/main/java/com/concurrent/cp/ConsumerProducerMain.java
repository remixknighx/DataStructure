package com.concurrent.cp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class ConsumerProducerMain {

    public static void main(String[] args) {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        // 运行生产者
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        // 运行消费者
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer1.stop();
        producer2.stop();
        producer3.stop();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

}
