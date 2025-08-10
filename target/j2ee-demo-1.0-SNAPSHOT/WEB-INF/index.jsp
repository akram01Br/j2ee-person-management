<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="com.example.j2eedemo.model.Person"%>
<%
  List<Person> persons = (List<Person>)request.getAttribute("persons");
%>
<!doctype html>
<html>
<head><title>Persons</title></head>
<body>
  <h1>People</h1>
  <a href="<%=request.getContextPath()%>/WEB-INF/add.jsp">Add person</a>
  <table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th></tr>
    <c:forEach var="p" items="${persons}">
      <tr>
        <td>${p.id}</td><td>${p.name}</td><td>${p.email}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
