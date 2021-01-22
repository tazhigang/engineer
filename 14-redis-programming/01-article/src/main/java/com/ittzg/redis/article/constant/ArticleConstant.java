package com.ittzg.redis.article.constant;

/**
 * @author: tazhigang
 * @date: 2021/1/22 13:20
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class ArticleConstant {
    public static final int ONE_WEEK_IN_SECONDS = 7 * 86400;  //文章发布7天后失效，不能投票
    public static final int VOTE_SCORE = 400;//获取一票后文章分值加400
    public static final int ARTICLES_PER_PAGE = 25; //分页查询每页显示25条

    public static final String articleKeyPrefix = "article:";
    public static final String articleScoreInfoKey = "score:info";
    public static final String timeSortInfoKey = "time:sort:info";
    public static final String articleVoteInfoKey = "vote:";
    public static final String userInfoKeyPrefix = "user:";
}
