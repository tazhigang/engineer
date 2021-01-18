package com.ittzg.enginner.concurrent._01.sleep;

/**
 * @author: ittzg
 * @date: 2021/1/18 14:20
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class Sleep_NoLock_Case {


    public static void main(String[] args) {

        new Thread(Sleep_NoLock_Case::thread01).start();


        new Thread(Sleep_NoLock_Case::thread02).start();


    }



    public static void thread01(){
        System.out.println("开始执行thread01方法");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成thread01执行");


    }


    public static void thread02(){
        System.out.println("开始执行thread02()方法");

        System.out.println("完成thread02执行");
    }
}
