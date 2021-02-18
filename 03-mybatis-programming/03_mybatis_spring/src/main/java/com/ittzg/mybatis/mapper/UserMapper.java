package com.ittzg.mybatis.mapper;


import com.ittzg.mybatis.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author: ittzg
 * @date: 2020/11/3 14:30
 * @Email: tazhigang095@163.com
 * @desc:
 */
//@Repository
public interface UserMapper {


    UserEntity findById(Long id);
}
