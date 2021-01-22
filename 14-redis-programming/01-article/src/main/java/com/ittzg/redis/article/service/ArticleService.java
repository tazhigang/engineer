package com.ittzg.redis.article.service;

import com.ittzg.redis.article.pojos.dto.ArticleDto;
import com.ittzg.redis.article.pojos.entity.ArticleEntity;

import java.util.List;

/**
 * @author: tazhigang
 * @date: 2021/1/22 10:33
 * @Email: tazhigang095@163.com
 * @desc:
 */
public interface ArticleService {

    void postArticle(ArticleEntity articleEntity);

    void voteArticle(String articleId,Long userId);

    List<ArticleDto> findAllByPublishTime(int pageSize,int page);

    List<ArticleDto> findAllByScore(int pageSize,int page);
}
