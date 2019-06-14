<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录-物料管理系统</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.do" method="post">
用户名：<input name="name" type="text"/><br>
	密码：<input name="pwd" type="password"/><br>
	<input type="submit" value="登录"> ${message}
</form>
	
	

</body>
</html>