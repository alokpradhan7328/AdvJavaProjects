<%@page import="java.util.Iterator"%>
<%@page import="test.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<table border="1">
  <tr>
    <th>Employee ID</th>
    <th>Name</th>
    <th>Designation</th>
    <th>Basic Salary</th>
    <th>HRA</th>
    <th>DA</th>
    <th>Total Salary</th>
  </tr>
<%
ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)request.getAttribute("alist");
Iterator<EmployeeBean> it = al.iterator();
while(it.hasNext())
{
    EmployeeBean eb = (EmployeeBean)it.next();
%>
  <tr>
    <td><%= eb.geteId() %></td>
    <td><%= eb.geteName() %></td>
    <td><%= eb.geteDesg() %></td>
    <td><%= eb.getbSal() %></td>
    <td><%= eb.getHra() %></td>
    <td><%= eb.getDa() %></td>
    <td><%= eb.getTotSal() %></td>
  </tr>
<%
}
%>
</table>
<%@include file="home.html"%>
</body>
</html>
