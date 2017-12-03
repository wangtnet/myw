package com.luobo.user.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.luobo.common.MailUtils;
import com.luobo.common.VerifyCodeUtils;
import com.luobo.user.dao.userMapper;
import com.luobo.user.pojo.user;
import com.sun.xml.internal.ws.api.pipe.Tube;

@Service("userService")
public class UserService  implements IUserService{
	
	@Resource
	private userMapper userDao;

	@Override
	public int register(user record) {
		// TODO Auto-generated method stub
		record.setRegistertime(new Date());
		
		if(record.getRegistercode()==null){
			String rstCode = VerifyCodeUtils.generateVerifyCode(4);
			record.setRegistercode(rstCode.toString());
			int ret = userDao.insert(record);
			if(1 == ret)
				MailUtils.sendRegister(record.getEmail(),rstCode.toString());
		}else{
			user u = userDao.selectByName(record.getUsername().trim());
			if(u.getRegistercode().equals(record.getRegistercode().trim())){
				//激活--还要加个激活的字段 to thi tha
			}
		}
		
		//还有错误时的日志
		return 1;
	}

	@Override
	public boolean checkUser(user u,HttpSession session) {
		
		if(u==null)
			return false;
		
		System.err.println(u.getUsername());
		user du=userDao.selectByName(u.getUsername());
		
		if(du==null){
        	System.out.println("login--"+u.getUsername()+",id = "+session.getId()+"true");
			return false;
		}
		else{
        	session.setAttribute("logined", true);
            
        	session.setAttribute("user", du);
        	//获取session的Id
        	String sessionId = session.getId();
        	System.out.println("login--"+u.getUsername()+",id = "+session.getId()+"true");
			return true;
		}
	}
	


}

