package com.luobo.room.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.luobo.room.pojo.room;
import com.luobo.room.service.IRoomService;
import com.luobo.user.service.IUserService;
import com.sun.org.apache.regexp.internal.recompile;



@Controller
@RequestMapping("/room")
public class roomController {
	@Resource
	private IRoomService roomService;
	
	@RequestMapping(method = RequestMethod.POST)
	public  @ResponseBody  
	String insertRoom(room r){
		//int r = userService.register(r);
		System.out.println("now"+r.getLiid());
		if (r.getLiid().trim().isEmpty() ) {
			Long lliid = System.currentTimeMillis();
			r.setLiid(lliid.toString());
			r.setId(null);
			
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
			return ret.toString();
		}

	}
	
	@RequestMapping(method = RequestMethod.GET,value="all")
	public  @ResponseBody  
	List<room> selectRoom(){
		List<room> rooms = roomService.selectAllRooms();
		return rooms;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="{liid}")
	public  @ResponseBody  
	room selectRoomByLiid(@PathVariable("liid") String liid){
		return roomService.selectByLiid(liid);
	}
	
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
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody 
   public String upload(
           @RequestParam("one-specific-file") CommonsMultipartFile upfile,
           HttpServletRequest req,Integer rommid) throws IOException {
       // |获取在Web服务器上的 绝对路径

	   
       System.out.println("come-->roomid="+rommid);
       String path = req.getRealPath("/WEB-INF/static/");
       System.out.println(path);
       // |获取输入流
       InputStream is = upfile.getInputStream();
       // |文件输出流
       OutputStream os = new FileOutputStream(new File(path,upfile.getOriginalFilename()));

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
       //room r =new room();
       
       
       // ===渲染===
       System.out.println("come2");
       // ModelAndView mView = new ModelAndView();
       // mView.setViewName("upload");
       // |返回至渲染器
       return upfile.getOriginalFilename();
   }
}
