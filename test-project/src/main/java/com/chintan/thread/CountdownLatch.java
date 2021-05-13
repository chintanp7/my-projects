package com.chintan.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                System.out.println("Hello World");
                countDownLatch.countDown();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
        countDownLatch.await();
        System.out.println("End");
    }
}
