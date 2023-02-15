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
    <title>Category Form</title>
</head>
<body>

<div class="container text-center">
    <c:if test="${category==null}">
    <h1>======= ADD NEW CATEGORY ========</h1>
    </c:if>
        <c:if test="${category!=null}">
        <h1>======= EDIT CATEGORY ========</h1>
            </c:if>


    <div class="row">
        <div class="col-md-6 offset-3">
            <c:if test="${category==null}">
                <form action="/categories" method="post">
                </c:if>
                <c:if test="${category!=null}">
                <form action="/categories/edit" method="post">
                    <input type="hidden" value="${category.id}" name="id">
                    </c:if>
                    <div class="mb-3">

                        <label for="Name" class="form-label">Name</label>
                        <input name="name" type="text" value="${category.name}" class="form-control" id="Name">
                    </div>
                    <div class="mb-3">
                        <label for="Description" class="form-label">Description</label>
                        <input name="description" type="text" value="${category.description}" class="form-control"
                               id="Description">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
        </div>
    </div>
</div>
<a href="/" class="btn btn-primary mt-4">Main Menu</a></body>

</body>
</html>
