<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="User.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.app.action.LoginAction" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title><s:text name="操作成功页面"/></title>  
<meta http-equiv="Content-Type" content="text/html; charset=GBK">  
</head>  
<body>  
<%if(session.getAttribute("type").equals("2")){%>
<lable value="注册成功!">  <label>
<tr>
<td>
</td>
</tr>
您的账号<s:property value="username"/>
您的密码<s:property value="password"/>
<a href="loginForm" >请登录</a>
<br/>  
<%}%>

<%if(session.getAttribute("type").equals("3")){%>
<lable value="删除成功!">  <label>
<tr>
<td>
</td>
</tr>

<a href="welcome" >返回原页面</a>
<br/>  
<%}%>
<%if(session.getAttribute("type").equals("4")){%>
<lable value="修改成功!"> 
新密码为<s:property value="password"/> <label>
<tr>
<td>
</td>
</tr>

<a href="welcome" >返回原页面</a>
<br/>  
<%}%>
<%if(session.getAttribute("type").equals("5")){

LoginAction a = new LoginAction();
List<User> list = a.select();
%>
<lable value="查询成功!"> 
 </lable>
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
						<table>
						<tbody>

<%for(User tl:list){ %>

<tr>		
        <th class="left"><%=tl.getId() %></th>
        <th><%=tl.getUsername() %></th>
        <th><%=tl.getPassword() %></th>
        <th><%=tl.getRoleid() %></th>
</tr>
<%}%>


<a href="welcome" >返回原页面</a>
<br/>  
<%}%>
</body>  
</html>  
