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
<link href="css/userManagStyle.css" rel='stylesheet' type='text/css' />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
function hideURLbar(){ window.scrollTo(0,1); } 
function check(){
	if(Searchform.fTel.value == ""){
		alert("SEARCH USER不能为空！");
		return false;
	}
}
</script>

<title>userManag</title>
</head>
<body>
 <div class="main">
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
		<div class="login-form">
				
			<form action="findById" name="Searchform" method="post" onsubmit="return check()">
				SEARCH USER：<input type="text" name='fTel' placeholder="fTel">
					<div class="submit">
						<input type="submit" value="SEARCH" >
					</div>		
			</form>
		</div>
</div>
		
</body>
</html>