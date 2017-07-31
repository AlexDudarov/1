<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>
<body>
<c:import url="header.jsp"/>
<div id="page-wrap">
<div class="col-md-2">
	<form action="registration" method="post">
		<div class="form-group">
			<label for="login">Login</label>
			<input type="text" class="form-control" id="login"  name="login" placeholder="Login">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" id="password" name="password" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-default">Registrate</button>
	</form>
</div>
</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>