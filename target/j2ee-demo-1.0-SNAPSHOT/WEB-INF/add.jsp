<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head><title>Add Person</title></head>
<body>
  <h1>Add person</h1>
  <form action="${pageContext.request.contextPath}/persons" method="post">
    Name: <input name="name"><br>
    Email: <input name="email"><br>
    <button type="submit">Add</button>
  </form>
  <a href="${pageContext.request.contextPath}/persons">Back</a>
</body>
</html>
