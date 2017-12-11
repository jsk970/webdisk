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