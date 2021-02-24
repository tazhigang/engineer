package com.ittzg.enginner.concurrent._01.join;

/**
 * @author: tazhigang
 * @date: 2021/1/18 15:01
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class Join_Case {


    private static final Object lock = new Object();

    public static Thread thread_01;


    public static Thread thread_02;

    public static Thread thread_03;

    public static void main(String[] args) {

        thread_01 = new Thread(Join_Case::thread01);

        thread_02 = new Thread(Join_Case::thread02);


        thread_03 = new Thread(Join_Case::thread03);

        thread_01.start();
        try {
            thread_01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=========主函数===============");


    }

    public static void thread01() {

        synchronized (lock) {
            System.out.println("开始执行thread01方法");

            try {
                thread_02.start();
                thread_02.join();

                thread_03.start();
                thread_03.join();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("完成thread01执行");
        }


    }


    public static void thread02() {
        synchronized (lock) {
            System.out.println("开始执行thread02()方法");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("完成thread02执行");
        }
    }


    public static synchronized void thread03() {
        System.out.println("开始执行thread03()方法");
        System.out.println("完成thread03执行");
    }
}
