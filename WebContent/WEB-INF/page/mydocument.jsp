<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的文档</title>
<link href="css/findByIdResultStyle.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div class="main">
		<div class="login-form">
					<div class="daohang">
					<a href="AllDocument">我的文档</a>
					</div>
					<div class="daohang">
						<a href="findAll_Friend">我的好友</a>
					</div>
					<div class="daohang">
						<a href="SkipUpload">上传文件</a>
					</div>
					<div class="daohang">
						<a href="skipUserReach">添加好友</a>
					</div>
					<div class="daohang">
						<a href="skipuserUpdate">修改个人信息</a>
					</div>
			
		
		
			<table border="1" class="ResultTable">
			<tr>
				
				<th>fTitle</th>
				<th>fType</th>
				<th>fUploadTime</th>
				<th>fSize</th>
				<td>fCatelog</td>
				<th>操作</th>
			</tr>
			<c:forEach var="item" items="${DocumentList}">
			<tr>
				
				<td>${item.fTitle }</td>
				<td>${item.fType }</td>
				<td>${item.fUploadTime }</td>
				<td>${item.fSize }KB</td>
				<td>
				<c:forEach var="item2" items="${Cateloglist }">
					<c:if test="${item.fCatelog==item2.fid }">
					${item2.fCatelog}
					</c:if>
				</c:forEach ></td>
				<td>
				<input type="button" value="删除" onclick="location='delete_Document?fid=${item.fid }&filename=${item.fTitle}&deletefile=${item}'">
				
				<input type="button" value="下载" onclick="location='downloadfile?filename=${item.fTitle }'">
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>