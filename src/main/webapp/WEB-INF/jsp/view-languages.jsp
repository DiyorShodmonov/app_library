<%--
  Created by IntelliJ IDEA.
  User: oybek
  Date: 9/8/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="Css.jsp"></jsp:include>
    <title>Languages</title>
</head>
<body>
<div class="container text-center">

    <h1>======= LANGUAGES ========</h1>

    <a class="btn btn-outline-primary my-4" href="/languages/get-form">+ Add new author</a>
    <div class="row">
        <div class="col-md-6 offset-3">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${languages}" var="lang" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>
                            ${lang.name}
                        </td>
                        <td>
                            <a class="btn btn-warning" href="/languages/edit?id=${lang.id}">EDIT</a>
                            <a class="btn btn-danger" href="/languages/delete/${lang.id}">DELETE</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>
<a href="/" class="btn btn-primary mt-4">Main Menu</a></body>
</body>
</html>
