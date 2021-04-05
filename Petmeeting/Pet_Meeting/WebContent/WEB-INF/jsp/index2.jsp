<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
</head>
<body>
	<div class="collapse navbar-collapse" id="navbar-collapse2">
		<ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="../index.html">Posts</a></li>
			{{^sessionedUser}}
			<li><a href="/users/loginForm" role="button">로그인</a></li>
			<li><a href="/users/form" role="button">회원가입</a></li>
			{{/sessionedUser}} {{#sessionedUser}}
			<li><a href="/reservations/form" role="button"><b>Make
						Reserve</b></a></li>
			<li><a href="/reservations" role="button"><b>Reservation
						List</b></a></li>
			<li><a href="/users/logout" role="button">로그아웃</a></li>
			<li><a href="/users/{{id}}/form" role="button">개인정보수정</a></li>
			{{/sessionedUser}}
		</ul>
	</div>

</body>
</html>