package com.ittzg.design.decorator;

/**
 * @author: tazhigang
 * @date: 2020/11/10 17:47
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class TestDecorator {


    public static void main(String[] args) {

        new RedPenDecorator(new RedPen()).write();

    }
}
