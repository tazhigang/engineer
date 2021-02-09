package com.ittzg.distributed.lock.spi;

/**
 * @author: tazhigang
 * @date: 2021/2/9 10:33
 * @Email: tazhigang095@163.com
 * @desc:
 */
public interface DistributedLock {

    boolean tryLock();


    void unLock();
}
