<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">  
<title><s:text name="注册页面" /></title>  
</head>  
<body>
<form action="register.action" method="post">
	姓名:<input type="text" name="username"/><br>
	密码:<input type="text" name="password"/><br>
	<input type="submit" value="注册"><br>
</form> 
</body>
</html>
