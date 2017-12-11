<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/findByIdResultStyle.css" rel='stylesheet' type='text/css' />
<title>查找结果</title>
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
				<th>FriendTel</th>
				<th>fUser</th>
				<th>fMemo</th>
				<th>operation</th>
				</tr>
			<c:forEach items="${Friendlist }" var="Friend">
			<tr>
				<td>${Friend.fFriendTel }</td>
				<td>${Friend.fUser }</td>
				<td>${Friend.fMemo }</td>
				<td><input type="button" value="deleteFriend" onclick="location='delete_Friend?FriendTel=${Friend.fFriendTel }'"/></td>
			</tr>
			</c:forEach>
		   
		</table>
		
	</div>
</div>
</body>
</html>