<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
			${sessionScope.userId}, ${userId} <!-- 내장 객체를 표현해주는 표현식(sessionScope) 생략 가능 -->
	</h1>
</body>
</html>