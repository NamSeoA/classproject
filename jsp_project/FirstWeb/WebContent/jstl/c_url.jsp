<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:url value="/index.jsp"/> <br>
	<c:url value="index.jsp"/> <br>
	<c:url value="/index.jsp" var="indexLink"/> 
	${indexLink} <br>
	
	<!-- url 안에 param 넣어서 경로 만들 수 있음 -->
	<c:url value="/index.jsp">
		<c:param name="pageNumber" value="1"/>
		<c:param name="keyword" value="jstl"/>
	</c:url>
	
</body>
</html>