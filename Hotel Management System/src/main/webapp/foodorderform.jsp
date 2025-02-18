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

    <form:form action="saveFoodOrder" modelAttribute="foodOrderObj">
       Enter name :    <form:input path="name"/>
       Enter mobilenumber :    <form:input path="mobilenumber"/>
       Enter address :    <form:input path="address"/>
       <input type ="submit">
    </form:form>

</body>
</html>