package com.luobo.room.service;

import java.util.List;

import com.luobo.room.dao.roomMapper;
import com.luobo.room.pojo.room;

public interface IRoomService {

	int updateRoom(room r);
	
	int insertRoom(room r);
	
    room selectByLiid(String liid);
    
    List <room> selectAllRooms();
}
