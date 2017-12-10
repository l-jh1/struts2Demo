<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title><s:text name="操作失败页面"/></title>  
<meta http-equiv="Content-Type" content="text/html; charset=GBK">  
</head>  
<body>  
<%if(session.getAttribute("type").equals("2")){%>
<s:text name="注册失败"/>  
<%}%>

<%if(session.getAttribute("type").equals("3")){%>
<lable value="删除失败!">  <label>
<tr>
<td>
</td>
</tr>

<a href="welcome" >返回原页面</a>
<br/>  
<%}%>

<%if(session.getAttribute("type").equals("4")){%>
<lable value="修改失败!"> 
新密码为<s:property value="password"/> <label>
<tr>
<td>
</td>
</tr>

<a href="welcome" >返回原页面</a>
<br/>  
<%}%>
</body>  