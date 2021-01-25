package com.ittzg.redis.article.service;

import com.alibaba.fastjson.JSONObject;
import com.ittzg.redis.article.ArticleApplication;
import com.ittzg.redis.article.pojos.dto.ArticleDto;
import com.ittzg.redis.article.pojos.entity.ArticleEntity;
import com.ittzg.redis.article.utils.IdWorker;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: tazhigang
 * @date: 2021/1/22 13:38
 * @Email: tazhigang095@163.com
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticleApplication.class)
class ArticleServiceTest {

    private static IdWorker worker;

    @Autowired
    ArticleService articleService;

    private static ArticleService threadArticleService;


    private static final List<String> list = new ArrayList<>();

    @PostConstruct
    public void init(){
        worker = new IdWorker(1,1,1);
        threadArticleService = articleService;
        list.add("107625840489140224");
        list.add("107625840480751616");
        list.add("107625840472363008");
        list.add("107625840413642752");
        list.add("107625840405254144");
        list.add("107625840396865536");
        list.add("107625840388476928");
        list.add("107625840380088320");
        list.add("107625840363311104");
        list.add("107625839646085120");
        list.add("107628469957038080");
        list.add("107628469613105152");
        list.add("107628469604716544");
        list.add("107628469596327936");
        list.add("107628469587939328");
        list.add("107628469579550720");
        list.add("107628469571162112");
        list.add("107628469562773504");
        list.add("107628469545996288");
        list.add("107628468820381696");
    }

    @Test
    public void postArticle(){


        for (int i = 0; i < 20 ; i++) {
            ArticleEntity articleEntity = ArticleEntity.builder()
                    .id(Long.parseLong(list.get(i)))
                    .title("title"+i)
                    .content("content1")
                    .publishTime(new Date())
                    .userId(Long.parseLong((System.currentTimeMillis()+"").substring(5)))
                    .build();
            articleService.postArticle(articleEntity);
        }


    }

    @Test
    public void voteArticle() {
        for (int i = 0; i <1000 ; i++) {
            int index = new SecureRandom().nextInt(19);
            Long userId = Long.parseLong((worker.nextId()+"").substring(5));
            System.out.println(Thread.currentThread().getName()+":userId="+userId+":index="+index);
            threadArticleService.voteArticle(list.get(index),userId);
        }
    }

    @Test
    public void findAllByPublishTime(){
        List<ArticleDto> articleDtos = articleService.findAllByPublishTime(15, 1);

        System.out.println(JSONObject.toJSONString(articleDtos));


    }

    @Test
    public void findAllByScore(){
        List<ArticleDto> articleDtos = articleService.findAllByScore(15, 1);

        System.out.println(JSONObject.toJSONString(articleDtos));

    }



}