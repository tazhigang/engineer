package com.ittzg.distributed.lock.spi.impl.mysql;

import com.ittzg.distributed.lock.spi.DistributedLock;
import org.springframework.stereotype.Component;

/**
 * @author: tazhigang
 * @date: 2021/2/9 10:36
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Component(value = "mysqlLock")
public class MysqlLock implements DistributedLock {


    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void unLock() {

    }
}
