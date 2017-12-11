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
import org.springframework.web.multipart.MultipartFile;

import webdisk.bean.Catelog;
import webdisk.bean.Document;
import webdisk.bean.User;
import webdisk.service.Impl.ICatelogServiceImpl;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.services.ICatelogService;
import webdisk.services.IDocumentService;
import webdisk.util.DateUtil;


@Controller
public class FileController {
	
	@RequestMapping("/SkipUpload")
	public String SkipUpload(){
		return "uploadfile";
		
	}
	@RequestMapping("/UpLoadFile")
	public String UpLoadFile(MultipartFile file,String fCatelog,HttpServletRequest request,
			HttpSession session,Model model) throws IllegalStateException, IOException{
		
		
		
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		
		
		IDocumentService is = new IDocumentServiceImpl();
		List<Document> list = null;
		list = is.findAllDocument(myTel);
		String filename = file.getOriginalFilename();
		System.out.println("Documentlist:"+list);
		
		int result = 0;
		for(Document doc:list)
		{
			if(doc.getfTitle().equals(filename))
			{
				System.out.println("doc.getfTitle():"+doc.getfTitle());
				result = 0;
			}else {
				result = 1;
			}
		}
		
		if(result ==1||list.size()==0) {
			String serverPath = request.getServletContext().getRealPath("/uploadfile")+"/"+myTel;
			System.out.println("serverPath:"+serverPath);
			
			String ext_name = filename.substring(filename.length()-3); 
			
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
			doc.setfType(ext_name);
			Date date = new Date();
			String time = DateUtil.dateToStr(date);
			doc.setfUploadTime(time);
			doc.setfTel(myTel);
			long fSize = (long) (file.getSize()/1024.00);
			
			doc.setfSize(fSize);
			String filepath = "uploadfile/"+filename;
			doc.setfPath(filepath);
			
			System.out.println("file.getSize():"+file.getSize());
			doc.setfIntroduction("Introduction");
			doc.setfMemo("fMemo");
			doc.setfCatelog(fCatelog);
			ds.addDocument(doc);
			List<Document> DocumentList = is.findAllDocument(myTel);
			model.addAttribute("DocumentList",DocumentList);
			ICatelogService Icate = new ICatelogServiceImpl();
			List<Catelog> cateloglist=  Icate.findCatelogAll(myTel);
			
			model.addAttribute("Cateloglist",cateloglist);
				
			return "mydocument";
			
		}else
			return "file_existed";
	}
	
	@RequestMapping("/AllDocument")
	public String Alldocument(HttpSession session,Model model) {
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		IDocumentService is = new IDocumentServiceImpl();
		List<Document> DocumentList = is.findAllDocument(myTel);
		model.addAttribute("DocumentList",DocumentList);
		session.setAttribute("DocumentList",DocumentList);
		
		ICatelogService Icate = new ICatelogServiceImpl();
		List<Catelog> cateloglist=  Icate.findCatelogAll(myTel);
		model.addAttribute("Cateloglist",cateloglist);
		session.setAttribute("Cateloglist",cateloglist);
		return "mydocument";
		
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete_Document")
	public String delete_Document(HttpServletRequest request,int fid,String filename,Model model
			,HttpSession session,Document deletefile) {
		
		String serverPath = request.getServletContext().getRealPath("/uploadfile/");
		
		String path =serverPath+filename;
		System.out.println(path);
		
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		IDocumentService is = new IDocumentServiceImpl();
		
		is.deleteDocument(fid);
		 
		 
		 
		System.out.println("删除成功!");
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		
		List<Document> DocumentList = is.findAllDocument(myTel);
		model.addAttribute("DocumentList",DocumentList);
		
		
		model.addAttribute("DocumentList",DocumentList);
		return "mydocument";
		
	}
	

}
