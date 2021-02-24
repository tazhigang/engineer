package com.ittzg.redis.article.pojos.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.*;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity {

    private Long id;

    private String title;

    private String content;

    private Date publishTime;

    private Long userId;

    public Map<String,String> toMap(){
        Map<String, String> strMap = new HashMap<>();
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(this);
        for (String key : jsonObject.keySet()) {
            strMap.put(key,jsonObject.get(key).toString());
        }
        return strMap;
    }
}
