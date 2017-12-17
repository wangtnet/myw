package com.luobo.room.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.luobo.room.pojo.room;
import com.luobo.room.service.IRoomService;
import com.luobo.user.pojo.user;

@Controller
@RequestMapping("/room")
public class roomController {
	@Resource
	private IRoomService roomService;
	
	@RequestMapping(method = RequestMethod.POST)
	public  @ResponseBody  
	String insertRoom(room r){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
		System.out.println("now"+r.getLiid());
		if (r.getLiid()==null) {
			Long lliid = System.currentTimeMillis();
			r.setLiid(lliid.toString());
			r.setId(null);
			user u =(user)session.getAttribute("user");
			r.setUserid(u.getId());
			Integer ret = roomService.insertRoom(r);
					System.out.println(
				r.getLiid() + "," + r.getAreaname() + "," + r.getCourtname() + "," + r.getSurroundinginfo());
	
			System.out.println("insert ret = " + ret);
			return lliid.toString();
		}
		else{
			
			room room =roomService.selectByLiid(r.getLiid().trim());
			r.setLiid(room.getLiid());
			Integer ret = roomService.updateRoom(r);
			System.out.println("update ret = "+ret);
			
			System.out.println(
					r.getLiid() + "," + r.getAreaname() + "," + r.getCourtname() + "," + r.getSurroundinginfo());
			return room.getLiid().toString();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,value="all")
	public  @ResponseBody  
	List<room> selectRoom(){
		List<room> rooms = roomService.selectAllRooms();
		return rooms;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/liid/{liid}")
	public  @ResponseBody  
	room selectRoomByLiid(@PathVariable("liid") String liid){
		return roomService.selectByLiid(liid);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/mepublish")
	public  @ResponseBody  
	List<room> selectRoomByUserid()
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        user u =(user)session.getAttribute("user");
		return roomService.selectByUserid(u.getId());
	}
	

	@RequestMapping(value = "/upload/{roomid}", method = RequestMethod.POST)
	@ResponseBody 
    public String upload(
           @RequestParam("one-specific-file") CommonsMultipartFile upfile,
           HttpServletRequest req, @PathVariable("roomid") String rommid) throws IOException {
       // |获取在Web服务器上的 绝对路径
       System.out.println("come-->roomid="+rommid);
       room room=roomService.selectByLiid(rommid);
       if(room==null)
    	   return "wrong";
       
       String path = req.getRealPath("/WEB-INF/static/");
       Integer imageNum=1;
       
       //这种的反射 to thi tha
       if(room.getImage1()==null){
    	   imageNum=1;
    	   room.setImage1(rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename());
       }
       else if(room.getImage2()==null){
    	   imageNum=2;
    	   room.setImage2(rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename());
       }
       else if(room.getImage3()==null){
    	   imageNum=3;
    	   room.setImage3(rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename());
       }
       else if(room.getImage4()==null){
    	   imageNum=4;
    	   room.setImage4(rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename());
       }
       else if(room.getImage5()==null){
    	   imageNum=5;
    	   room.setImage5(rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename());
       }
       else {
    	   return "imageout5";
       }
    	   
       
       String imageName =rommid+"_"+imageNum.toString()+"_"+upfile.getOriginalFilename();
       System.out.println(path);
       roomService.updateRoom(room);
       // |获取输入流
       InputStream is = upfile.getInputStream();
       // |文件输出流
       //OutputStream os = new FileOutputStream(new File(path,upfile.getOriginalFilename()));
       OutputStream os = new FileOutputStream(new File(path,imageName));
       System.out.println("come0");
       // |循环写入
       int length = 0;
       byte[] buffer = new byte[128];
       while ((length = is.read(buffer)) != -1) {
           os.write(buffer, 0, length);
       }
       System.out.println("come1");
       is.close();
       os.close();
       System.out.println("come2");
       
       return imageName;
   }
}


/*
@RequestMapping(method = RequestMethod.PUT)
public  @ResponseBody  
String updateRoom(room r){
	//int r = userService.register(r);
	System.out.println(r.getLiid()+","+r.getAreaname()+","
			+r.getCourtname()+","
			+r.getSurroundinginfo());
	Integer ret = roomService.updateRoom(r);
	System.out.println("update ret = "+ret);
	return ret.toString();
}
*/
/*
@RequestMapping(method = RequestMethod.PUT)
public  @ResponseBody  
String updatRoom(room r){
	room room =roomService.selectByLiid(r.getLiid().trim());
	r.setLiid(room.getLiid());
	Integer ret = roomService.updateRoom(r);
	System.out.println("update ret = "+ret);
	
	System.out.println(
			r.getLiid() + "," + r.getAreaname() + "," + r.getCourtname() + "," + r.getSurroundinginfo());
	return ret.toString();
}
*/
