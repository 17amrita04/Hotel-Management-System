<%@page import="java.util.List"%>
<%@page import="com.jsp.hotelmanagementsystem.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
    <%
     List<Product> products = (List) request.getAttribute("products");
     %>
     <table cellpadding="20px" border="1">
          <th>id</th>
          <th>name</th>
          <th>type</th>
          <th>cost</th>
          <th>discount</th>
          <th>update</th>
          <th>delete</th>
     
          <%
          for (Product p : products){
          %>
          <tr>
             <td><%=p.getId()%></td>
             <td><%=p.getName()%></td>
             <td><%=p.getType()%></td>
             <td><%=p.getCost()%></td>
             <td><%=p.getDiscount()%></td>
             <td><a href="updateproduct?id=<%=p.getId()%>">update</a></td>
             <td><a href="delete?id=<%=p.getId()%>">delete</a></td>
          </tr>
          <%
          }
          %>
      </table>
      <a href="hoteloptions.jsp">Back to main menu </a>
      <br>
      <a href="hotellogout">Logout</a>
</body>
</html>