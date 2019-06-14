<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员管理</title>
   	<script type="text/javascript">
   		function del(aid)
   		{
   	   		if(confirm("确定删除吗?"))
   	   		{
   	   			window.location.href="DeleteAdminServlet?aid="+aid;
   	   	   	}
   	   		
   	   	}
   		function upd(aid)
   		{
   	   		window.location.href="FindAdminByIdServlet?aid="+aid;
   	   	}
   	</script>
  </head>
  <body>
  	<center>
	  	<div>
	   		<h1>管理员管理</h1>
	   		<span><a href="addAdmin.jsp">添加管理员</a></span>
	   		<table width="500" cellspacing="0" border="1">
	   			<tr>
	   				<td>编号</td>
	   				<td>名称</td>
	   				<td>状态</td>
	   				<td colspan="2">操作</td>
	   			</tr>
	   			
	   				<c:forEach items="${alist}" var="a">
	   				<tr valign="middle">
	   					<td>${a.aid }</td>
		   			
		   				<td>${a.adminName }</td>

		   				<c:if test="${a.state == 1}">
		   					<td>超级</td>
		   				</c:if>	
		   				<c:if test="${a.state == 0}">
		   					<tD>普通</td>
		   				</c:if>	
		   				
		   				<td>
		   					<input type="button" value="修改" onclick="upd(${a.aid})"/>
		   				</td>
		   				<td>
			   				<input type="button" value="删除" onclick="del(${a.aid})"/>
						</td>
					</tr>
	   				</c:forEach>
	   				

	   		</table>
	   		<p/>
	   		
	   		<span><a href="GetAllProductsServlet">返回主页</a></span>
	   	</div>
   	</center>
  </body>
</html>
