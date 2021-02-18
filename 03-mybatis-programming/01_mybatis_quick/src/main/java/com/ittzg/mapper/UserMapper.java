package com.ittzg.mapper;

import com.ittzg.entity.UserEntity;

/**
 * @author: ittzg
 * @date: 2020/11/3 14:30
 * @Email: tazhigang095@163.com
 * @desc:
 */
public interface UserMapper {


    UserEntity findById(Long id);
}
