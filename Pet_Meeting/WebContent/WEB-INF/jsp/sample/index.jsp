<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
</head>
<body>
<c:if test="${member == null}">
        <form action='<c:url value='/admin/login'/>' method="post">
            <div>
                <label>아이디</label>
                <input id="memberId" name="memberId">    
            </div>
            <div>
                <label>비밀번호</label>
                <input id="memberPass" name="memberPass">
            </div>
            <input type="submit" value="로그인">    
            <input type="button" value="회원가입" onclick="location.href='register'">
        </form>
</c:if>
 
<c:if test="${member != null}">
<c:redirect url="/boardList"/>
</c:if>
 
</body>
</html>
