package com.ittzg.tree;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: tazhigang
 * @date: 2021/2/8 13:49
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class Btree {

    public static void main(String[] args) {

        Thread thread = new Thread();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    }
}
