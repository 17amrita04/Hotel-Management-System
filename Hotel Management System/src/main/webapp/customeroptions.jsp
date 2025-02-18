<%@page import="com.jsp.hotelmanagementsystem.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    Integer customer_id = (Integer) session.getAttribute("customerinfo");
    if(customer_id != null){
    %>
	<a href="readhotelname.jsp">View Items By Hotel</a>
    <br>
	<a href="fetchallproducts">Buy products</a>
	<br>	
	<a href="readpricerange.jsp">View products  between price Range</a>
	
	<%
	} else {
	%>
	<h1><a href = "customerlogin.jsp">Login First</a></h1>
	 <%
     }
     %>
</body>
</html>