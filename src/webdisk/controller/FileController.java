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
import webdisk.bean.User;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.services.IDocumentService;
import webdisk.util.DateUtil;


@Controller
public class FileController {
	
	@RequestMapping("/SkipUpload")
	public String SkipUpload(){
		return "uploadfile";
		
	}
	@RequestMapping("/UpLoadFile")
	public String UpLoadFile(@RequestParam("uploadfile") MultipartFile file,
			HttpServletRequest request,HttpSession session,Model model) throws IllegalStateException, IOException{
		
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		
		String serverPath = request.getServletContext().getRealPath("/uploadfile")+"/"+myTel;
		System.out.println("serverPath:"+serverPath);
		String filename = file.getOriginalFilename();
		//String ext_name = filename.substring(filename.length()-3); 
		
		File server = new File(serverPath);
		if(!server.exists())
		server.mkdirs();	
		filename = new String(filename.getBytes("GBK"),"utf-8");
		String path = serverPath+"/"+filename ;
		System.out.println("path:"+path);
		if(!file.isEmpty()) {
			//上传文件
			file.transferTo(new File(path));
		}
		IDocumentService ds = new IDocumentServiceImpl();
		Document doc = new Document();
		doc.setfTitle(filename);
		doc.setfType("type");
		Date date = new Date();
		String time = DateUtil.dateToStr(date);
		doc.setfUploadTime(time);
		doc.setfTel(myTel);
		file.getSize();
		String filepath = "uploadfile/"+filename;
		doc.setfPath(filepath);
		
		
		System.out.println("file.getSize():"+file.getSize());
		doc.setfIntroduction("Introduction");
		doc.setfMemo("fMemo");
		
		ds.addDocument(doc);
		
		List<Document> list = null;
		list = ds.findAllDocument(myTel);
		model.addAttribute("DocumentList",list);
		
		return "mydocument";
		
	}

}
