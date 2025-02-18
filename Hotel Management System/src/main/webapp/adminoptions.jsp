<%@page import="com.jsp.hotelmanagementsystem.entities.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
    <%
    Admin a = (Admin) session.getAttribute("admininfo");
    if(a != null){
    %>

    ${message}
    <br>
	<a href="fetchunapproveddhotels">Approve Hotel</a>
    <br>
	<a href="fetchunblockedhotels">Block Hotel</a>
    <br>
	<a href="fetchblockedhotels">Unblock Hotel</a>
    <br>
	<a href="providediscount">Provide Discount</a>
	<br>
	
	<%
    }else{
	%>
	<a href = "Adminlogin.jsp">Login First</a>
	 <%
     }
     %>
</body>
</html>