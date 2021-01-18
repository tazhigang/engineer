package com.ittzg.enginner.concurrent._01.yield;

/**
 * @author: ittzg
 * @date: 2021/1/18 14:06
 * @Email: tazhigang095@163.com
 * @desc: yield()函数介绍
 * <p>
 * 让出CPU资源，但是不释放锁资源
 *
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。
 * 在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
 */
public class Yield_Case {



    public static void main(String[] args) {

        new Thread(()->{

            System.out.println("开始执行thread01方法");


            Thread.yield();


            System.out.println("完成thread01执行");
        }).start();


        new Thread(()->{
            System.out.println("开始执行thread02()方法");

            Thread.yield();


            System.out.println("完成thread02执行");
        }).start();

    }

}
