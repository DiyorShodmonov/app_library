<%--
  Created by IntelliJ IDEA.
  User: oybek
  Date: 9/8/2022
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="Css.jsp"></jsp:include>
    <title>Language Form</title>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <c:if test="${lang==null}">
            <h1>======= ADD NEW LANGUAGE ========</h1>
        </c:if>
        <c:if test="${lang!=null}">
            <h1>======= EDIT LANGUAGE ========</h1>
        </c:if>
        <div class="col-md-6 offset-3">
            <c:if test="${lang==null}">
            <form action="/languages" method="post">
                </c:if>
                <c:if test="${lang!=null}">
                <form action="/languages/edit" method="post">
                    <input type="hidden" value="${lang.id}" name="id">
                    </c:if>
                    <div class="mb-3">
                        <label for="Name" class="form-label">Name</label>
                        <input name="name" type="text" value="${lang.name}" class="form-control" id="Name">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
        </div>
    </div>
</div>
<a href="/" class="btn btn-primary mt-4">Main Menu</a></body>

</body>
</html>
