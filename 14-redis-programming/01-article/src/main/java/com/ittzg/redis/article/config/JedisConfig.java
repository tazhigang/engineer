package com.ittzg.redis.article.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: tazhigang
 * @date: 2021/1/22 11:19
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Configuration
@Component
public class JedisConfig extends JedisPool {

    @Autowired
    RedisConfigProperties redisConfigProperties;


    @Override
    public Jedis getResource() {
        return super.getResource();
    }


    public void returnResource(Jedis resource) {
        super.returnResource(resource);
    }
}
