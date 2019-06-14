<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物料管理系统</title>
</head>
<body>
欢迎 ${admin.name}
<a href="${pageContext.request.contextPath }/add.do?name=test&pwd=444">register</a><br>
<a href="${pageContext.request.contextPath }/logout.do">logout</a>
   
</body>
</html>