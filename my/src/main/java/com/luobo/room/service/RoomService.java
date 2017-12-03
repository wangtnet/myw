package com.luobo.room.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luobo.room.dao.roomMapper;
import com.luobo.room.pojo.room;


@Service("roomService")
public class RoomService implements IRoomService {

	@Resource
	private roomMapper roomDao;
	
	@Override
	public
	int updateRoom(room r){
		room r1 =roomDao.selectByLiid(r.getLiid());
		if(r1==null)
			return 0;
		r.setId(r1.getId());
		return roomDao.updateByPrimaryKeySelective(r);
	}
	
	@Override
	public
	int insertRoom(room r){
		
		return roomDao.insert(r);
	}

	@Override
	public room selectByLiid(String liid) {
		// TODO Auto-generated method stub
		return roomDao.selectByLiid(liid);
	}

	@Override
	public List<room> selectAllRooms() {
		// TODO Auto-generated method stub
		return roomDao.selectAllRooms();
	}

	@Override
	public List<room> selectByUserid(long userid) {
		// TODO Auto-generated method stub
		return roomDao.selectByUserid(userid);
	}
	
	
}
