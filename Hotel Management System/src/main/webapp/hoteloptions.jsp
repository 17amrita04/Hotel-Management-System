<%@page import="com.jsp.hotelmanagementsystem.entities.Hotel"%>
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
     Integer hotel =(Integer) session.getAttribute("hotelinfo");
     if(hotel != null){
     %>
     <h1>${message}</h1>
     <a href="addproduct">Add Product</a>
     <br>
     <a href="fetchallhotelproducts">View All Products</a>
     <br>
     <a href="updateproduct">Update Product by Id</a>
     <br>
     <a href="">Delete Product by Id</a>
     <br>
     
     <%
     }else{
     %>
     <a href="Hotellogin.jsp">Login First</a>
     <%
     }
     %>
</body>
</html>