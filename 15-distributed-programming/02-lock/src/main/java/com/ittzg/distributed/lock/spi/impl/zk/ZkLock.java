package com.ittzg.distributed.lock.spi.impl.zk;

import com.ittzg.distributed.lock.spi.DistributedLock;
import org.springframework.stereotype.Component;

/**
 * @author: tazhigang
 * @date: 2021/2/9 15:33
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Component(value = "zkLock")
public class ZkLock implements DistributedLock {


    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void unLock() {

    }
}
