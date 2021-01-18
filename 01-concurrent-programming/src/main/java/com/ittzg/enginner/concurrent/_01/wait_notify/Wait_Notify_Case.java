package com.ittzg.enginner.concurrent._01.wait_notify;

/**
 * @author: tazhigang
 * @date: 2021/1/18 14:55
 * @Email: tazhigang095@163.com
 * @desc:
 * wait():
 * wait(time)：
 *
 *
 */
public class Wait_Notify_Case {

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(Wait_Notify_Case::threadA);


        Thread threadB = new Thread(Wait_Notify_Case::threadB);


        threadA.start();


        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        threadB.start();
    }



    public static void threadA(){
        synchronized (lock){

            System.out.println("threadA() start ......");


            try {
                lock.wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("threadA() end ......");
        }


    }


    public static void threadB(){
        synchronized (lock){

            System.out.println("threadB() start ......");

            System.out.println("threadB() end ......");


            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notifyAll();



        }
    }
}
