<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Вход</title>
</head>
<body>
<c:import url="header.jsp"/>
<div id="page-wrap">
<form action="login" method="post" name="registration">
		Error:<c:out value="${error}"/><br>
		Username: <input type="text" value="admin" name="login"><br>
		Password: <input type="password" value="admin" name="password"> <br>
		<input type="submit" class="button" value="LogIn"><br>
		<h2>Привет ${sessionScope.user.login}</h2>
		<h2> ${message}</h2>
	</form>
	</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>