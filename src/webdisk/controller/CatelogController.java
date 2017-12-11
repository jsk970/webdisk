package webdisk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import webdisk.bean.Catelog;
import webdisk.bean.User;
import webdisk.service.Impl.ICatelogServiceImpl;
import webdisk.services.ICatelogService;

@Controller
public class CatelogController {
	@RequestMapping("/skipto_addCatelog")
	public String skipto_addCatelog() {
		return "addCatelog";
	}
	
	
	@RequestMapping("/addCatelog")
	public String addCatelog(HttpSession session,String fCatelog) {
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		ICatelogService is = new ICatelogServiceImpl();
		Catelog catelog = new Catelog();
		catelog.setfTel(myTel);
		catelog.setfCatelog(fCatelog);
		is.addCatelog(catelog);
		
		
		return null;
		
	}
}
