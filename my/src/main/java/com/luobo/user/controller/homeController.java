package com.luobo.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
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
        if(userService.checkUser(u, session)){
        	ModelAndView mad = new ModelAndView("home","message","msg1");
        	return mad;
		}else{
			ModelAndView mad = new ModelAndView("loginm","messeage","loginerror");	
        	return mad;
		}   
	}

	@RequestMapping(value="homer")
	public  @ResponseBody  
	ModelAndView  homer(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();

		ModelAndView mad = new ModelAndView("home","message","msg2");
		return mad;
	}
	
	@RequestMapping(value="head")
	public  @ResponseBody  
	ModelAndView  header(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
      
        if(session.getAttribute("logined")==null){
        	return new ModelAndView("head","loginFlag",false);
        }else{
        	Boolean logined =(Boolean)session.getAttribute("logined");
        	System.out.println("head-->"+logined);
        	return new ModelAndView("head","loginFlag",logined);
		}
	}
	
	@RequestMapping(value="loginm")
	public  @ResponseBody  
	ModelAndView  loginm(){
		ModelAndView mad = new ModelAndView("loginm");
		return mad;
	}
	@RequestMapping(value="exitm")
	public  @ResponseBody  
	ModelAndView  exitm(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("logined", false);
		ModelAndView mad = new ModelAndView("loginm");
		return mad;
	}
	
	@RequestMapping(value="registerm")
	public  @ResponseBody  
	ModelAndView  registerm(){
		ModelAndView mad = new ModelAndView("registerm");
		return mad;
	}
	
	
	@RequestMapping(value = "addroom")
	public @ResponseBody ModelAndView addRoom() {
		// int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();

		if (session.getAttribute("logined") == null) {
			return new ModelAndView("addroom", "loginFlag", false);
		} else {
			Boolean logined = (Boolean) session.getAttribute("logined");
			System.out.println("head-->" + logined);
			return new ModelAndView("addroom", "loginFlag", logined);
		}
	}

	@RequestMapping(value="account")
	public  @ResponseBody  
	ModelAndView  account(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        
        if (session.getAttribute("logined") == null) {
			return new ModelAndView("account", "loginFlag", false);
		} else {
			Boolean logined = (Boolean) session.getAttribute("logined");
			System.out.println("head-->" + logined);
			return new ModelAndView("account", "loginFlag", logined);
		}

	}


	@RequestMapping(value="roomm")
	public  @ResponseBody  
	ModelAndView  roomm(){
		//int r = userService.register(u);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
		
        if (session.getAttribute("logined") == null) {
			return new ModelAndView("roomm", "loginFlag", false);
		} else {
			Boolean logined = (Boolean) session.getAttribute("logined");
			System.out.println("head-->" + logined);
			return new ModelAndView("roomm", "loginFlag", logined);
		}
	}
	
}
