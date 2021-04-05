<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 상품 보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>결   과(DB 데이터 추가 완료 시 Mapper 작성 후 수정 예정)</h2>
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>연령</th>
					<th>가족 구성원(수)</th>
					<th>TV 추천 결과</th>
					<th>인터넷 속도</th>
					<th>모바일 데이터</th>
					<th>모바일 통화량</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${age}</td>
					<td>${family}</td>
					<td>${tv.tvDue}</td>
					<td>
					<c:forEach var="data" items="${tv.tvSer}">
					${data} 
					</c:forEach>
					</td>
					<td>${internet.itnSpeed}</td>
					<td>${mobile.mobData}</td>
					<td>${mobile.mobVoice}</td>
				</tr>
			</tbody>
		</table>
		<a href="selection">돌아가기</a>
	</div>
</body>

</html>