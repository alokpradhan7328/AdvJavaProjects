<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result_In_Jsp</title>
</head>
<body>
	<%
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	float price = Float.parseFloat(request.getParameter("price"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	
	out.println("ProdeuctCode: "+code+"<br>");
	out.println("ProdeuctName: "+name+"<br>");
	out.println("ProdeuctPrice: "+price+"<br>");
	out.println("ProdeuctQty: "+qty+"<br>");
	%>
	<%@ include file="product.html" %>
</body>
</html>