<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  		request.setAttribute("userName", "손흥민1");
		  session.setAttribute("userName", "손흥민2");
		  application.setAttribute("userName", "손흥민3");
  		session.setAttribute("userId", "son");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>
			requestScope.userName : ${requestScope.userName}, 								<!-- 표현언어 -->
															${userName}, 	<!-- 같은 이름을 가졌을 때는 위에서부터 순차적으로 보면서 작은 순서 이름 출력 -->
														<%= request.getAttribute("userName") %> <br> <!-- jsp -->
														
			sessionScope.userId : ${sessionScope.userId}, ${userId},
													  <%= session.getAttribute("userId") %>	<br>
													  
			param.code : <%= request.getParameter("code") %>, 
										${param.code} <br>
										
			pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>, 
										${pageContext.request.contextPath},
										${pageContext.request.requestURI},  <!-- /FirstWeb/el/elObject.jsp -->
										${pageContext.request.requestURL}   <!-- http://localhost:8080/FirstWeb/el/elObject.jsp -->
										
	</h1>
	<a href="view1.jsp"> session 페이지 확인</a>
</body>
</html>