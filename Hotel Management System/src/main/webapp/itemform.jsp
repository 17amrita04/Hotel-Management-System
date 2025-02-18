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
     <form:form action = "saveItemtoorder" modelAttribute="itemobj">
         Name :          <form:input path="name" readonly = "true"/>
         Type :          <form:input path="type" readonly = "true"/>
         Cost :          <form:input path="cost" readonly = "true"/>
         Enter Quantity: <form:input path="quantity" />
         <input type="submit">
     </form:form>
</body>
</html>