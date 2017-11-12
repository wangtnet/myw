package com.luobo.user.dao;

import com.luobo.user.pojo.user;

public interface userMapper {
    int deleteByPrimaryKey(Long id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Long id);
    
    user selectByName(String username);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}