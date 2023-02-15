<%--
  Created by IntelliJ IDEA.
  User: oybek
  Date: 9/9/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
  <jsp:include page="Css.jsp"></jsp:include>
</head>
<body>
<h1>Name: ${category.name}</h1><br>
<h1>Description: ${category.description}</h1>
<a href="/" class="btn btn-primary mt-4">Main Menu</a></body>
</body>
</html>
