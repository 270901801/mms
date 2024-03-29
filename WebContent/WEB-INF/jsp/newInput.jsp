<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新品入库</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jilian.js"></script>
    <script type="text/javascript" src="js/valName.js"></script>
    <script type="text/javascript">
   		var isSubmit = false;
    	function checkForm()
    	{
        	var bid = document.getElementById("bigtype").value;
        	var name = document.getElementById("name").value;
        	var units = document.getElementById("units").value;
        	if(bid == 0)
            {
                alert("请选择产品类别");
                return false; 
            }
        	if(name == "")
            {
                alert("请输入产品名称");
                return false; 
            }
        	if(units == "")
            {
                alert("请输入产品单位");
                return false; 
            }
            if(isSubmit == false)
            {
                alert("请仔细核对后信息再点入库，输入后无法更改！");
                isSubmit = true;
                return false;
            }
            return true;
        }
    	
    	 function changeTypes(bid){
         	
         	//alert(bid);
     		//1、把bid发送到smallcontroller中
     		//2、如果调用成功 则会执行回调函数 并把servlet中返回的数据获得
     		$.getJSON("${pageContext.request.contextPath }/selectSmallByBid.do?bid="+bid,
     				function(data){
     			//alert(data);
     			//清空下拉列表
     			$("#smalltype").empty();
     			
     			//通过ID来控制第二个下拉列表
     			//循环data
     			$.each(data,function(i,obj){
     				
     				$("#smalltype").append("<option value="+obj.sid+">"+obj.sname+"</option>");
     			});
     		});
         }
    </script>
  </head>
  <body>
   		<center>
   			<h1>新品入库</h1>
   			<h3><a href="${pageContext.request.contextPath }/selectAll.do">返回主页</a></h3>
   			<h4><font color="red">产品名称是唯一的，名称尽量详细（例如：诺基亚3301）</font></h4>
   			<form action="${pageContext.request.contextPath }/newProduct.do" method="post" onsubmit="return checkForm()">
   				<table width="500" cellspacing="0" border="1">
   					<tr>
   						<td>选择大类:</td>
   						<td>
   							<select id="bigtype" name="bid" onchange="changeTypes(this.value)">
   							<option value="0" selected>--请选择--</option>
   								<c:forEach items="${bigList}" var="bt">
				  					<option value="${bt.id}">${bt.name}</option>
				  				</c:forEach>
   							</select>
   							<a href="${pageContext.request.contextPath }/addBigType">添加大类</a>
   						</td>
   					</tr>
   					<tr>
   						<td>选择小类:</td>
   						<td>
   							<select id="smalltype" name="sid">
   								<option value="0" selected>--请选择--</option>
   							</select>
   							<a href="${pageContext.request.contextPath }/addSmallType">添加小类</a>
   						</td>
   					</tr>
   					<tr>
   						<td>产品名称:</td>
   						<td>
   							<input id="name" name="name" size="30"/>
   							<font color="red">*</font>
   							 <span id="message"></span>
   						</td>
   					</tr>
   					<tr>
   						<td>单位:</td>
   						<td>
   							<input id="units" name="units" size="10"/>
   						</td>
   					</tr>
   					
   					<tr>
   						<td>预警值:</td>
   						<td>
   							<input name="wvalue" value="10" size="4"/>
   						</td>
   					</tr>
   					
   					<tr align="center">
   						<td colspan="2">
   							<input type="submit" value="入  库">
   						</td>
   					</tr>
   				</table>
   			</form>
   		</center>
  </body>
  <c:set scope="session" value="true" var="flag"/>
</html>
