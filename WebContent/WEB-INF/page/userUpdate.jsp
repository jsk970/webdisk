<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/registStyle.css" rel='stylesheet' type='text/css' />


<script type="text/javascript" src="js/userdate.js">
	
</script>
<title>修改个人信息</title>
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
			<h1>修改信息</h1>
					<div class="head">
						<img src="image/user.png" alt=""/>
					</div>
				<form action="userUpdate" name="registform" method="post" enctype="multipart/form-data" onsubmit="return check()">
						FTEL：${loginUser.fTel}<br/>
						PASSWORD：<input type="password" name="fPassword" ><br/>
						PASSWORD AGAIN:<input type="password" name="fPwd" ><br/>
						NAME:<input type="text" name="fUser" value="${loginUser.fTel}"><br/>
						修改头像:<img alt="无头像" src="${loginUser.fPhoto}" width="100"/><input type="file" name="fphoto" value="选择文件"><br/>
						INTRODUCE:<input type="text" name="fIntroduction" value="${loginUser.fIntroduction}">
						<div class="submit">
							<input type="submit"  value="SUMBIT" onclick="return Passwordcheck()" >
							<input type="reset"  value="RESET">
							<a href="skipuserMenu">取消修改</a>
							
					</div>	
				</form>
			</div>
			
 
				
		</div>
		
</body>
</html>