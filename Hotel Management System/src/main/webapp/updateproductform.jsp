<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form:form action="updateproductinfo" modelAttribute="existingProductInfo">
	   Id:           <form:input path="id" readonly="true" /><br>
	   Enter Name:   <form:input path="name" /><br>
	   Enter Type:   <form:input path="type" /><br>
	   Enter Cost:   <form:input path="cost" /><br>
	   Enter discount:   <form:input path="discount" /><br>
	    <input type="submit">
	</form:form>
</body>
</html>