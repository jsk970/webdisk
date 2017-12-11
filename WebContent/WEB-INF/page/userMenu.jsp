<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.clear{
clear:both;
}
.dierhang{
margin-top:20px;
float:left;

width:100%;
height: 200px;
}
.dierhang{

padding-top:30px;
}
.dierhang img{
margin-left: 100px;
}
.dierhang p{
margin-left: 100px;
}
.dierhang img p{
	margin-left:10px;
	text-align:center;
	align-content: center;
}
.div_table1{
	float:left;
	width: 100%;
	height: 300px;
	margin: 20px auto;
}
.table1 th{
font-size:20px;
background-color: gray;
}
.table1 td{
	text-align:center;
	border:1px solid gray;
}
.div_table2{
	float:left;
	width: 100%;
	height: 300px;
}
.table2 th{
	font-size:20px;
	background-color: gray;
}
.table2 td{
	text-align:center;
	border:1px solid gray;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/menuStyle.css" rel='stylesheet' type='text/css' />
<title>User Menu</title>
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
		
		
		<div class="dierhang">
			<div class="image">			
				<img src="${loginUser.fPhoto }" width="150">
				<p>账号:${loginUser.fTel}</p>
								
			</div>
			<div class="info">
				<p>姓名：${loginUser.fUser}</p>
				<p>等级:${loginUser.fLevel}</p>
				<p>个人简介:${loginUser.fIntroduction}</p>
				<p>网盘空间:${loginUser.fSize}G</p>
			</div>
			
		</div>
	
			<div class="div_table1">
				
				<table class="table1" >
					<tr class="table1_th">
						<th colspan="10">我的文档</th>
					</tr>
					<tr class="table1_td">
						<td>标题</td>
						<td>类型</td>
						<td>分类</td>
						<td>上传时间</td>
						<td>下载次数</td>
						<td>点赞次数</td>	
					</tr>
					<c:forEach var="doc" items="${DocumentList }" >
					<tr>
						<td>${doc.fTitle }</td>
						<td>${doc.fType }</td>
						<td>
							<c:forEach var="item2" items="${Cateloglist }">
								<c:if test="${doc.fCatelog==item2.fid }">
									${item2.fCatelog}
								</c:if>
							</c:forEach >
						</td>
						<td>${doc.fUploadTime }</td>
						<td>${doc.fDownloadCount }</td>
						<td>${doc.fGoodCount }</td>
					</tr>
				</c:forEach>
				</table>
		</div>
		
		</div>
			</div>
			<div class="clear"></div>
			
		
</body>
</html>