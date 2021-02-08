package com.ittzg.enginner.concurrent._06;

import java.util.concurrent.*;

/**
 * @author: tazhigang
 * @date: 2021/2/5 10:39
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class MyThreadPoolExecutor {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            System.out.println("-------------start-----------------");

            try {
                TimeUnit.SECONDS.sleep(2L);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                System.out.println("-------");
                countDownLatch.countDown();
                e.printStackTrace();
            }
            System.out.println("-------------end-----------------");

        });
        thread.start();
        TimeUnit.SECONDS.sleep(1L);
        thread.interrupt();
        countDownLatch.await();
        System.out.println("-------------main-----------------");
    }
}
