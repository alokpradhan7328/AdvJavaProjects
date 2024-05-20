<%@page import="test.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User_Profile</title>
</head>
<body>
<%
String cVal =(String)request.getAttribute("cVal");
out.println("Page Belongs to User : "+cVal+"<br>");
UserBean ub =(UserBean)application.getAttribute("ubean");
out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+ub.getAddr()+"&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getPhNo());
%>
<a href="edit">EditProfile</a>
<a href="logout">LogOut</a>
</body>
</html>