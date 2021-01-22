package com.ittzg.redis.article.config;

import com.ittzg.redis.article.utils.IdWorker;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: tazhigang
 * @date: 2021/1/22 10:33
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfigProperties {

    private String host;

    private int port;
}
