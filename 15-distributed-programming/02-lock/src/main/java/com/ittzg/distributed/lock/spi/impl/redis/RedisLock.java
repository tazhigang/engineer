package com.ittzg.distributed.lock.spi.impl.redis;

import com.ittzg.distributed.lock.spi.DistributedLock;
import org.springframework.stereotype.Component;

/**
 * @author: tazhigang
 * @date: 2021/2/9 15:32
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Component(value = "redisLock")
public class RedisLock implements DistributedLock {


    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void unLock() {

    }
}
