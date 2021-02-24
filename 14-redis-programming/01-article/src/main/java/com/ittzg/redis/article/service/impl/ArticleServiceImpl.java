package com.ittzg.redis.article.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ittzg.redis.article.config.JedisConfig;
import com.ittzg.redis.article.config.RedisConfigProperties;
import com.ittzg.redis.article.pojos.dto.ArticleDto;
import com.ittzg.redis.article.pojos.entity.ArticleEntity;
import com.ittzg.redis.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.Writer;
import java.util.*;

import static com.ittzg.redis.article.constant.ArticleConstant.*;

/**
 * @author: tazhigang
 * @date: 2021/1/22 10:45
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private RedisConfigProperties redisConfigProperties;


    @Autowired
    private JedisConfig jedisConfig;



    @Override
    public void postArticle(ArticleEntity articleEntity) {
        Jedis jedis = jedisConfig.getResource();
        try {
            String articleId = articleKeyPrefix + articleEntity.getId();
            String votId = articleVoteInfoKey + articleEntity.getId();
            // 将文章数据存储至redis
            jedis.hset(articleId, articleEntity.toMap());
            // 设置文章分数
            jedis.zadd(articleScoreInfoKey, 1, articleId);
            // 日期排序
            jedis.zadd(timeSortInfoKey, articleEntity.getPublishTime().getTime(), articleId);
            // 投票记录
            jedis.sadd(votId, userInfoKeyPrefix + articleEntity.getUserId());
            jedis.expire(votId, ONE_WEEK_IN_SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            if (jedis != null) {
                jedisConfig.returnResource(jedis);
            }
        }finally {
            if (jedis != null) {
                jedisConfig.returnResource(jedis);
            }
        }
    }

    @Override
    public void voteArticle(String articleId, Long userId) {


        Jedis jedis = jedisConfig.getResource();
        try {
            String votId = articleVoteInfoKey + articleId;
            articleId = articleKeyPrefix + articleId;
            long sadd = jedis.sadd(votId, userInfoKeyPrefix + userId);
            if (1L == sadd) {
                jedis.zincrby(articleScoreInfoKey, 1, articleId);
            } else {
                System.out.println("重复投票");
            }
        } catch (Exception e) {
        }finally {
            jedisConfig.returnResource(jedis);
        }

    }

    @Override
    public List<ArticleDto> findAllByPublishTime(int pageSize, int page) {
        Jedis jedis = jedisConfig.getResource();
        try {
            List<ArticleDto> list = new ArrayList<>();
            page = (page == 0) ? 1 : page;
            pageSize = (pageSize == 0) ? 20 : pageSize;
            long min = (page - 1) * pageSize;
            long max = page * pageSize - 1;
            Set<String> articleIds = jedis.zrevrange(timeSortInfoKey, min, max);
            int serNum = 1;
            JSONObject jsonObject;
            for (String articleId : articleIds) {
                Map<String, String> article = jedis.hgetAll(articleId);
                jsonObject = (JSONObject) JSONObject.toJSON(article);
                jsonObject.remove("id");
                jsonObject.remove("userId");
                ArticleDto articleDto = jsonObject.toJavaObject(ArticleDto.class);
                articleDto.setSerId(serNum);
                serNum++;
                list.add(articleDto);
            }
            return list;
        }finally {
            jedisConfig.returnResource(jedis);
        }
    }

    @Override
    public List<ArticleDto> findAllByScore(int pageSize, int page) {
        Jedis jedis = jedisConfig.getResource();
        try {
            List<ArticleDto> list = new ArrayList<>();
            page = (page == 0) ? 1 : page;
            pageSize = (pageSize == 0) ? 20 : pageSize;
            long min = (page - 1) * pageSize;
            long max = page * pageSize - 1;
            Set<String> articleIds = jedis.zrevrange(articleScoreInfoKey, min, max);
            int serNum = 1;
            JSONObject jsonObject;
            for (String articleId : articleIds) {
                Map<String, String> article = jedis.hgetAll(articleId);
                jsonObject = (JSONObject) JSONObject.toJSON(article);
                jsonObject.remove("id");
                jsonObject.remove("userId");

                ArticleDto articleDto = jsonObject.toJavaObject(ArticleDto.class);
                articleDto.setSerId(serNum);
                serNum++;
                list.add(articleDto);
            }
            return list;
        } finally {
            jedisConfig.returnResource(jedis);
        }
    }


}
