<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>添加文档分类</title>
</head>
<body>
 <div class="main">
		<div class="login-form">
			<form action="" name="Searchform" method="post" onsubmit="return check()">
				文档分类：<input type="text" name='fCatelog' >
				添加分类：
					<div class="submit">
						<input type="submit" value="确认添加" >
					</div>		
			</form>
		</div>
</div>
		
</body>
</html>