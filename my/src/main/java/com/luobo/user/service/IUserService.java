package com.luobo.user.service;

import javax.servlet.http.HttpSession;

import com.luobo.user.pojo.user;

public interface IUserService {
	int register(user u);
	
	boolean checkUser(user u,HttpSession session);
}
