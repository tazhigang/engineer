package com.ittzg.redis.article.pojos.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tazhigang
 * @date: 2021/1/22 10:46
 * @Email: tazhigang095@163.com
 * @desc:
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class ArticleDto {

    private int serId;

    private String title;

    private String content;

    private Date publishTime;

}
