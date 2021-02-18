package com.ittzg.design.decorator;

/**
 * @author: tazhigang
 * @date: 2020/11/10 17:43
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class BluePen implements Pen {
    @Override
    public void write() {
        System.out.println("bluePen");
    }
}
