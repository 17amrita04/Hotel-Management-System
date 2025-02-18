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
	<form:form action="savehotel" modelAttribute="hotelobj">
	   Enter Hotel name:   <form:input path="name" /><br>
	   Enter Contact num:   <form:input path="mobilenumber" /><br>
	   Enter email:   <form:input path="email" /><br>
	   Enter password:  <form:input path="password" /><br>
	   Enter address:   <form:input path="address" /><br>
	    <input type="submit">
	</form:form>
		
</body>
</html>