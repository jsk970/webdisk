package webdisk.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;




import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webdisk.bean.Document;
import webdisk.bean.Friend;
import webdisk.bean.User;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.service.Impl.IFriendServiceImpl;
import webdisk.service.Impl.IUserServiceImpl;
import webdisk.services.IDocumentService;
import webdisk.services.IFriendService;
import webdisk.services.IUserService;
import webdisk.util.DateUtil;

@Controller
public class UserController {
	
	@RequestMapping("/skipLogin")
	public String skipLogin(){
		
		return "userLogin";
	}
	@RequestMapping("/skipRegist")
	public String skipRegist(){
		
		return "userRegist";
	}
	
	@RequestMapping("/skipUserReach")
	public String skipUserReach(){
		
		return "userSearch";
	}
	
	
	@RequestMapping("/Regist")
	public String Regist(@RequestParam("fTel") String fTel,
			@RequestParam("fPassword") String fPassword,
			@RequestParam("fUser") String fUser,
			@RequestParam("fphoto") MultipartFile fphoto,
			@RequestParam("fintroduction") String fintroduction,
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		
			String serverPath = request.getServletContext().getRealPath("/image/user");
			System.out.println("serverPath:"+serverPath);
			String temp = fphoto.getOriginalFilename();
			String ext_name = temp.substring(temp.length()-3); 
			String path = serverPath+"/"+fTel+"."+ext_name ;
			
			System.out.println("path:"+path);
			if(!fphoto.isEmpty()) {
				//上传文件
				fphoto.transferTo(new File(path));
			}
			
			User user = new User();
			user.setfTel(fTel);
			user.setfPassword(fPassword);
			user.setfUser(fUser);
			String photo = "image/user/"+fTel+"."+ext_name;
			user.setfPhoto(photo);
			user.setfIntroduction(fintroduction);
			user.setfLevel("1LEVEL");
			user.setfSize(5);
			Date time = new Date();
			user.setfRegist(DateUtil.dateToStr(time));
			
			IUserService us = new IUserServiceImpl();
			us.regist(user);
		
			return "userLogin";
	}
	
	@RequestMapping("/Login")
	public String login(@RequestParam("fTel") String fTel,
			@RequestParam("fPassword") String fPassword,
			HttpSession session,
			Model model
			){
		
		IUserService us = new IUserServiceImpl();
		
		if(us.login(fTel, fPassword)){
			
			User user = us.findByfTel(fTel);
			session.setAttribute("loginUser",user);
			
			model.addAttribute("loginUser",user);
			IDocumentService is = new IDocumentServiceImpl();
		
			List<Document> list = null; 
			list = is.findAllDocument(fTel);
			model.addAttribute("DocumentList",list);
			return "userMenu";
		}
		
		return "userLogin";
	}
	@RequestMapping("/add_Friend")
	public String add_Friend(@RequestParam("fTel") String friendTel,HttpSession session,Model model){
		
		IFriendService  fs= new IFriendServiceImpl();
		/**
		 * 当前登录用户的fTel
		 */
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		/**
		 * 好友的fTel
		 */
	    Friend newfriend = fs.findByTel(friendTel);
		System.out.println("friendTel:"+friendTel);
		
		List<Friend> list = fs.findAllFriend(myTel);
		int result = 0;
		for(Friend friend:list)
		{
			if(friendTel.equals(friend.getfFriendTel())){
					result = 1;
			}
			
		}
		if(result == 1){
			
			System.out.println("对方已经是你的好友!");
			
		}else {
		//把好友添加到自己中
		Friend friend = new Friend();
		Friend friend2 = new Friend();
		friend.setfFriendTel(friendTel);
		friend.setfMytel(myTel);
		friend.setfMemo(newfriend.getfMemo());
		friend.setfUser(newfriend.getfUser());
		//把自己添加到好友中
		friend2.setfFriendTel(myTel);
		friend2.setfMytel(friendTel);
		friend2.setfMemo(loginuser.getfMemo());
		friend2.setfUser(loginuser.getfUser());
		
		fs.add(friend);
		fs.add(friend2);
//		System.out.println(friend+","+friend.getFid());
//		System.out.println(friend2+","+friend2.getFid());
		System.out.println("myTel:"+myTel+","+"FriendTel:"+friendTel);
		List<Friend> friendlist = null ;
		friendlist = fs.findAllFriend(myTel);
		model.addAttribute("Friendlist",friendlist);
		System.out.println("添加好友成功！");
		return "MyFriend";
		//	request.getRequestDispatcher("DocumentController").forward(request, response);
			//需要跳回到所有好友的列表
		}
		
		return null;
		
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam("fTel") String fTel,Model model) {

		IUserService us = new IUserServiceImpl();
		User user = null;
		user = us.findByfTel(fTel);
		if(user != null)
		{
				model.addAttribute("findFriend", user);
				return "findByIdResult";
			
		}else{
			return null;
		}

	}
	

	@RequestMapping("/delete_Friend")
	public String delete_Friend(@RequestParam("FriendTel") String FriendTel,
			HttpSession session,Model model){
		
		IFriendService fs = new IFriendServiceImpl();

		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		//System.out.println("myTel:"+myTel+","+"FriendTel:"+FriendTel);
		
		//删除好友
		if(fs.delete(FriendTel) != 0 && fs.delete(myTel) != 0)
		{
			List<Friend> friendlist = null ;
			friendlist = fs.findAllFriend(myTel);
			model.addAttribute("Friendlist",friendlist);
			System.out.println("删除好友成功！");
			return "MyFriend";
		}else 
			System.out.println("删除好友失败！");
		
			return null;
	}
	
	@RequestMapping("/findAll_Friend")
	public String delete_Friend(HttpSession session,Model model){
		
		IFriendService fs = new IFriendServiceImpl();

		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		
		List<Friend> friendlist = null ;
		friendlist = fs.findAllFriend(myTel);
		model.addAttribute("Friendlist",friendlist);
		
		return "MyFriend";
	}
	
}
