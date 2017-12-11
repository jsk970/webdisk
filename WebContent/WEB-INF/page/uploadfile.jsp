<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/userManagStyle.css" rel='stylesheet' type='text/css' />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
function hideURLbar(){ window.scrollTo(0,1); } 
function check(){
	if(Searchform.uploadfile.value == ""){
		alert("请选择上传文件！");
		return false;
	}
}
</script>

<title>userManag</title>
</head>
<body>
 <div class="main">
		<div class="login-form">
			<form action="UpLoadFile" method="post" enctype="multipart/form-data" onsubmit="return check()">
				选择文件：<input type="file" name="file" >
				选择文件类别：
				<select name="fCatelog">
				<c:forEach var="op" items="${Cateloglist}">
					<option value="${op.fid }">${op.fCatelog } </option>
				</c:forEach>
				
				</select>
					<div class="submit">
						<input type="submit" value="确认上传" >
					</div>		
			</form>
		</div>
</div>
</body>
</html>