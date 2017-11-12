package com.luobo.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.luobo.user.pojo.user;
import com.luobo.user.service.IUserService;

@Controller
public class homeController {
		@Resource
		private IUserService userService;
	@RequestMapping(value="home")
	public  @ResponseBody  
	ModelAndView  home(user u){
				
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("logined", userService.checkUser(u));
         //获取session的Id
        String sessionId = session.getId();
		System.out.println("login--"+u.getUsername()+",id = "+session.getId()+userService.checkUser(u));
		
		ModelAndView mad = new ModelAndView("home","message","msg1");
		return mad;
	}
	
	@RequestMapping(value="head")
	public  @ResponseBody  
	ModelAndView  header(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        boolean logined =(boolean)session.getAttribute("logined");
		System.out.println("head-->"+logined);
		ModelAndView mad = new ModelAndView("head","loginFlag",logined);
		return mad;
	}
	
	@RequestMapping(value="addroom")
	public  @ResponseBody  
	ModelAndView  addRoom(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        boolean logined =(boolean)session.getAttribute("logined");
		System.out.println("head-->"+logined);
		ModelAndView mad = new ModelAndView("addroom","loginFlag",logined);
		return mad;
	}
	
	
}
