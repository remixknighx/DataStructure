package com.concurrent.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wangjf
 * @date 2018/1/20 0020.
 */
public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 1. 单线程
         */
//        Callable<Integer> callable = new Callable<Integer>() {
//            public Integer call() throws Exception {
//                System.out.println("start>>>>>>");
//                Thread.sleep(3000);// 可能做一些事情
//                System.out.println("end>>>>>>");
//                return new Random().nextInt(100);
//            }
//        };
//
//        FutureTask<Integer> future = new FutureTask<Integer>(callable);
//        new Thread(future).start();
//        System.out.println("doing some other staff");
//        System.out.println(future.get());


        /**
         * 2. 使用线程池方式
         * */
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                System.out.println("start>>>>>>");
//                Thread.sleep(3000);         // 可能做一些事情
//                System.out.println("end>>>>>>");
//                return new Random().nextInt(100);
//            }
//        });
//
//        try {
//            Thread.sleep(100);
//            System.out.println("doing some other staff");
//            if(future.get() < 50){
//                System.out.println("小于50");
//            } else {
//                System.out.println("大于等于50");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        Callable<String> data = new RealData("a");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> result = executor.submit(data);

        System.out.println("开始处理其他业务》》》》》");
        Thread.sleep(500);

        System.out.println("取得的结果》》》》" + result.get());
    }

}
