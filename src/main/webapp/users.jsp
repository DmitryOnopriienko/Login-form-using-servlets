<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users</title>
</head>
<body>
  <table border="1">
    <thead><td>Login</td><td>Name</td></thead>
      <c:forEach var="user" items="${userList}">
        <tr>
          <td>${user.login}</td>
          <td>${user.name}</td>
        </tr>
      </c:forEach>
    </table><br><br>
    <a href="menu.jsp">Back to menu</a>
</body>
</html>
