<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/img/favicon.png" rel="shortcut icon" type="image/x-icon">


	<header>
		<a href="index" title="На главную" id="logo">Sport shop</a>
		<span class="contact"><a href="about">О нас</a></span>
		  <input type="text" class="field" placeholder="Найти">
		   <span class="right">

		   		<span class="contact">
		   			<a href="registration" title="Зарегистрироваться">Регистрация</a>
		   		</span>
				<c:if test="${sessionScope.user.role == null}">
		   		<span class="contact">
		    		<a href="login" title="Войти">Вход</a>
		   		</span>
				</c:if>
		   		<c:if test="${sessionScope.user.role eq 'ADMIN' or 'USER'}">
					<span class="contact">
					 <a href="logout">Выход</a>
					</span>
				</c:if>
	</span>
	</header>
	
	<nav>
		<ul>
			<li><a href="index">Главная</a></li>
			<li><a href="catalog">Каталог</a></li>
			<li><a href="contacts">Контакты</a></li>
			<li><a href="MyServlet?action=Shopping_Cart">Корзина</a></li>
			<c:if test="${sessionScope.user.role eq 'ADMIN'}"><li><a href="admin">Администрирование</a></li></c:if>
		</ul>
	</nav>
	

