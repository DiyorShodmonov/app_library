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
    <title>Author Form</title>
</head>
<body>

<div class="container text-center">
    <c:if test="${author==null}">
        <h1>======= ADD NEW AUTHOR ========</h1>
    </c:if>
    <c:if test="${author!=null}">
        <h1>======= EDIT AUTHOR ========</h1>
    </c:if>

    <div class="row">
        <div class="col-md-6 offset-3">
            <c:if test="${author==null}">
            <form action="/authors" method="post">
                </c:if>
                <c:if test="${author!=null}">
                <form action="/authors/edit" method="post">
                    <input type="hidden" value="${author.id}" name="id">
                    </c:if>
                    <div class="mb-3">

                        <label for="FullName" class="form-label">FullName</label>
                        <input name="fullName" type="text" value="${author.fullName}" class="form-control"
                               id="FullName">
                    </div>
                    <div class="mb-3">
                        <label for="authorBiography" class="form-label">Biography</label>
                        <input name="biography" type="text" value="${author.biography}" class="form-control"
                               id="authorBiography">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
        </div>
    </div>
</div>
<a href="/" class="btn btn-primary mt-4">Main Menu</a></body>
</html>
