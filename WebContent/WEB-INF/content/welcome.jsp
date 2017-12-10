<%@page import="User.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.app.action.LoginAction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<title><s:text name="登录成功页面"/></title>  
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="resources/css/colors/blue.css" />
		<!-- scripts (jquery) -->
		<script src="resources/scripts/jquery-1.4.2.min.js" type="text/javascript"></script>
		<!--[if IE]><script language="javascript" type="text/javascript" src="resources/scripts/excanvas.min.js"></script><![endif]-->
		<script src="resources/scripts/jquery-ui-1.8.custom.min.js" type="text/javascript"></script>
		<script src="resources/scripts/jquery.ui.selectmenu.js" type="text/javascript"></script>
		<script src="resources/scripts/jquery.flot.min.js" type="text/javascript"></script>
		<script src="resources/scripts/tiny_mce/tiny_mce.js" type="text/javascript"></script>
		<script src="resources/scripts/tiny_mce/jquery.tinymce.js" type="text/javascript"></script>
		<!-- scripts (custom) -->
		<script src="resources/scripts/smooth.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.menu.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.chart.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.table.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.form.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.dialog.js" type="text/javascript"></script>
		<script src="resources/scripts/smooth.autocomplete.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				style_path = "resources/css/colors";

				$("#date-picker").datepicker();

				$("#box-tabs, #box-left-tabs").tabs();
			});
		</script>
	</head>

<body>  
<lable value="登录成功!">  
欢迎<%=session.getAttribute("username") %>,<a href="logout">注销!</a>


<%
boolean role =false;
if(session.getAttribute("roleid").equals("admin")){
LoginAction a = new LoginAction();
role =true;
List<User> list = a.selectAll();%>

<br>
<form action="select" method="post">
<input type="text" id="username" name="username" size="40"  class="focus" />
<input type="submit" value="查询" />
</form>

<div class="table">
						<table>
							<thead>
								<tr>
									<th class="left">ID </th>
									<th>用户名</th>
									<th>密码</th>
									<th>权限</th>
									<th>操作</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
						</table>>

<%for(User tl:list){ %>

<tr>		
        <th class="left"><%=tl.getId() %></th>
        <th><%=tl.getUsername() %></th>
        <th><%=tl.getPassword() %></th>
        <th><%=tl.getRoleid() %></th>
		<th><%if(role) {%>  <a href = "delete.action?id=<%=tl.getId() %>">删除</a><%} %>
        <a href = "toedit?id=<%=tl.getId() %>">修改</a></th>
</tr>

<% } 
}
else{
LoginAction a = new LoginAction();
String id =session.getAttribute("id").toString();
List<User> list = a.selectById(id);
%>

<br>你没有权限，只能查看自己的信息
<br>
<div class="table">

						<table>
							<thead>
								<tr>
									<th class="left">ID </th>
									<th>用户名</th>
									<th>密码</th>
									<th>权限</th>
									<th>操作</th>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
								</tr>
							</thead>
						</table>

<%for(User tl:list){%>


<tr>		
        <th class="left"><%=tl.getId() %></th>
        <th><%=tl.getUsername() %></th>
        <th><%=tl.getPassword() %></th>
        <th><%=tl.getRoleid() %></th>
		<th><%if(role) {%>  <a href = "delete.action?id=<%=tl.getId() %>">删除</a><%} %>
        <a href = "toedit?id=<%=tl.getId() %>">修改</a></th>
</tr>
<%}
}%>						
						</tbody>
						</table>
</body>  
</html>  
