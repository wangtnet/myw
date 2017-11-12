package com.luobo.room.dao;

import java.util.List;

import com.luobo.room.pojo.room;

public interface roomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(room record);

    int insertSelective(room record);

    room selectByPrimaryKey(Long id);
    
    room selectByLiid(String liid);
    
    List <room> selectAllRooms();

    int updateByPrimaryKeySelective(room record);

    int updateByPrimaryKey(room record);
}