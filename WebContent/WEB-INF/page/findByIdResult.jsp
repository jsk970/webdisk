<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/findByIdResultStyle.css" rel='stylesheet' type='text/css' />
<title>查找结果</title>
</head>
<body>
<div class="main">
		<div class="login-form">
		
		
			
		<form action="add_Friend?fTel=${findFriend.fTel }" method="post">
			<table border="1" class="ResultTable">
			<tr>
				<th>fTel</th>
				<th>fUser</th>
				<th>fLevel</th>
				<th>fMemo</th>
				<th>f</th>
				<th>fIntroduction</th>
				
				<th>operation</th>
				
				</tr>
			<tr>
				<td>${findFriend.fTel }</td>
				<td>${findFriend.fUser }</td>
				<td>${findFriend.fLevel }</td>
				<td>${findFriend.fMemo }</td>
				<td>${findFriend.fTel }</td>
				<td>${findFriend.fIntroduction }</td>
				<td><input type="submit" value="addFriend"/></td>
			</tr>
		   
		</table>
		</form>
	</div>
</div>
</body>
</html>