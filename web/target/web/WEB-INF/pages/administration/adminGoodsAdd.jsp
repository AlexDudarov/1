<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление товара</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="adminHeader.jsp"/>
<div id="page-wrap">
    <div class="row center-block">

        <div class="col-md-2">
            <form action="${pageContext.request.contextPath}/admin/goods/add/good" method="post">
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" id="login" value="<c:out value="${loginObject.login}"/>" name="login" placeholder="Login">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" value="<c:out value="${loginObject.password}"/>" name="password" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">Login</button>
            </form>
        </div>
        <select><c:forEach var="brand" items="${brands}"><option value="">${brand.name}</option></c:forEach></select>
        <select><c:forEach var="type" items="${types}"><option value="">${type.name}</option></c:forEach></select>
</div>

</body>
</html>