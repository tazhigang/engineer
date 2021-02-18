package com.ittzg.design.decorator;

/**
 * @author: tazhigang
 * @date: 2020/11/10 17:44
 * @Email: tazhigang095@163.com
 * @desc:
 */
public abstract class PenDecorator implements Pen{

    private Pen pen;

    public PenDecorator(Pen pen) {
        this.pen = pen;
    }

    @Override
    public void write() {
        pen.write();
    }
}
