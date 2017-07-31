<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="sportequipment,sport,equipment">
<meta name="description" content="Sportequipment shop">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/img/favicon.png" rel="shortcut icon" type="image/x-icon">
<title>Главная страница</title>
</head>
<body>

<c:import url="header.jsp"/>
<div id="page-wrap">
<div id="index"><img src="resources/img/just.jpg">

</div>
	<c:out value="${news}"/>
	<form action="${pageContext.request.contextPath}/admin/goods/uploadImage" method="post" enctype="multipart/form-data">
		<input name="description" type="text"><br>
		<input name="data" type="file"><br>
		<input type="submit"><br>
	</form>
</div>

	<c:import url="footer.jsp"/>
	
</body>
</html>