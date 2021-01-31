package com.ittzg.redis.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: tazhigang
 * @date: 2020/7/31 10:13
 * @Email: tazhigang095@163.com
 * @desc:
 */
@SpringBootApplication
public class ArticleApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }

}
