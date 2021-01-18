package com.ittzg.enginner.concurrent._01.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tazhigang
 * @date: 2021/1/18 15:52
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class ThreadLocal_Case {

    public static final ThreadLocal<Integer> dataSource = new ThreadLocal<Integer>();


    public static Integer getNum(){
        return dataSource.get();
    }



    public static void setNum(Integer num){
        dataSource.set(num);
    }


    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        integers.stream().forEach(a->{

            new Thread(()->{
                ThreadLocal_Case.testThreadLocal(a);
            },"thread-"+a).start();
        });



    }


    public static void testThreadLocal(int i){
        System.out.println(Thread.currentThread().getId()+": set num="+ i);
        setNum(i);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getId()+": get num="+ getNum());
    }
}
