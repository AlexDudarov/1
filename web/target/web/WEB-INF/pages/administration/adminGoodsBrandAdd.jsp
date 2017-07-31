<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление бренда товара</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="adminHeader.jsp"/>
<div id="page-wrap">
    <form action="${pageContext.request.contextPath}/admin/goods/add/brand" method="post">
        <input name="brand_name"  type="text"><br>
        <input type="submit"><br>
    </form>
</div>

</body>
</html>