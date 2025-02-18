<%@page import="java.util.List"%>
<%@page import="com.jsp.hotelmanagementsystem.entities.Item"%>
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
    List<Item> items = (List) session.getAttribute("itemslist");
    %> 
    <table cellPadding = "20px" border = "1">
        <th>name</th>
        <th>cost</th>
        <th>type</th>
        <th>quantity</th>
        <th>remove</th>
    <%
    for(Item i : items){
    %>
      <tr>
         <td><%=i.getName() %></td>
         <td><%=i.getCost() %></td>
         <td><%=i.getType() %></td>
         <td><%=i.getQuantity() %></td>
         <td><a href="removeitem?id=<%=i.getName()%>">remove</a></td>
      </tr>    
    <%
    }
    %>
    </table>  
    <button><a href = "addfoodorder">Confirm</a></button>
</body>
</html>